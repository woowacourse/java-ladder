package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.line.RowLine;
import domain.name.Name;
import domain.name.Names;
import domain.prize.Prize;
import domain.prize.Prizes;

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

    public void printOneResult(Prize prize) {
        System.out.println(LINE_SEPARATOR + "실행 결과");
        System.out.println(prize.getPrizeName());
    }

    public void printAllResult(Map<Name, Prize> allResult) {
        System.out.println(LINE_SEPARATOR + "실행 결과");
        for (Name name : allResult.keySet()) {
            System.out.println(name.getName() + " : " + allResult.get(name).getPrizeName());
        }
    }
}
