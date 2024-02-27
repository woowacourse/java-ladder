package view;

import domain.ConnectionStatus;
import domain.Ladder;
import domain.UndecidedResults;
import domain.line.RowLine;
import domain.name.Name;
import domain.name.Names;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COLUMN_LINE = "|";
    private static final String FIVE_INTERVAL_FORMAT = "%-5s";
    private static final String BLANK = " ";
    private static final String ROW_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printLadder(Ladder ladder, Names names, UndecidedResults undecidedResults) {
        System.out.println(LINE_SEPARATOR + "사다리 결과" + LINE_SEPARATOR);
        System.out.println(resolveNamesMessage(names));
        System.out.println(resolveLadderMessage(ladder));
        System.out.println(resolveResultMessage(undecidedResults));
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

    private String resolveResultMessage(UndecidedResults undecidedResults) {
        return undecidedResults.getUndecidedResults().stream()
                .map(result -> String.format(FIVE_INTERVAL_FORMAT, result))
                .collect(Collectors.joining(BLANK));
    }

    public void printResult(String userInput, Map<Name, String> gameResult, Names names) {
        System.out.println(LINE_SEPARATOR + "실행 결과");
        String result = makeResultForPrint(userInput, names, gameResult);
        System.out.println(result);
    }

    private static String makeResultForPrint(String userInput, Names names, Map<Name, String> gameResult) {
        if (userInput.equals("all")) {
            return gameResult.keySet().stream()
                    .map(name -> (name.getName() + " : " + gameResult.get(name)))
                    .collect(Collectors.joining(LINE_SEPARATOR));
        }
        return gameResult.get(names.findName(userInput));
    }
}
