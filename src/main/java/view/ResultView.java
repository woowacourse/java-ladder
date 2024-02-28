package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.Prize;
import domain.Prizes;
import domain.line.RowLine;
import domain.name.Name;
import domain.name.Names;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COLUMN_LINE = "|";
    private static final String FIVE_INTERVAL_FORMAT = "%-5s";
    private static final String BLANK = " ";
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printLadder(Ladder ladder, Names names, Prizes prizes) {
        System.out.println(LINE_SEPARATOR + "사다리 결과" + LINE_SEPARATOR);
        System.out.println(resolveNamesMessage(names));
        System.out.println(resolveLadderMessage(ladder));
        System.out.println(resolveResultMessage(prizes));
    }

    private String resolveNamesMessage(Names names) {
        return names.getNames().stream()
                .map(name -> String.format(FIVE_INTERVAL_FORMAT, name.getName()))
                .collect(Collectors.joining(BLANK));
    }

    private String resolveLadderMessage(Ladder ladder) {
        return ladder.getLines().stream()
                .map(this::resolveLineMessage)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    private String resolveLineMessage(RowLine rowLine) {
        return "    " + COLUMN_LINE + rowLine.getConnections().stream()
                .map(this::resolveConnectionMessage)
                .collect(Collectors.joining(COLUMN_LINE)) + COLUMN_LINE;
    }

    private String resolveConnectionMessage(ConnectionStatus connectionStatus) {
        if (connectionStatus.isConnect()) {
            return ROW_LINE;
        }
        return EMPTY_LINE;
    }

    private String resolveResultMessage(Prizes prizes) {
        return prizes.getPrizes().stream()
                .map(prize -> String.format(FIVE_INTERVAL_FORMAT, prize.getPrizeName()))
                .collect(Collectors.joining(BLANK));
    }

    public void printResult(String onNameOrAll, Map<Name, Prize> gameResult, Names names) {
        System.out.println(LINE_SEPARATOR + "실행 결과");
        List<Prize> prizes = findPrizes(onNameOrAll, names, gameResult);
        printNamesAndPrizes(names, prizes);

    }

    private List<Prize> findPrizes(String onNameOrAll, Names names, Map<Name, Prize> gameResult) {
        if (onNameOrAll.equals("all")) {
            return gameResult.keySet().stream()
                    .map(gameResult::get)
                    .toList();
        }
        return List.of(gameResult.get(names.findName(onNameOrAll)));
    }

    private void printNamesAndPrizes(Names names, List<Prize> prizes) {
        for (int i = 0; i < prizes.size(); i++) {
            System.out.println(names.getNames().get(i).getName() + " : " + prizes.get(i).getPrizeName());
        }
    }
}
