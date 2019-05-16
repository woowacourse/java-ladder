package ladder.View;

import ladder.domain.Line;

import java.util.List;

public class OutputView {
    private static final String RESULT = "실행결과";
    private static final String ROW_LINE = "-";
    private static final String EMPTY_LINE = " ";
    private static final String COL_LINE = "|";

    public static void printResult(List<String> players) {
        System.out.println(RESULT);
        StringBuilder stringBuilder = new StringBuilder();
        for (String player : players) {
            stringBuilder.append(player);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printLadder(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EMPTY_LINE);
        stringBuilder.append(COL_LINE);
        for (Boolean rowLine : line.getRowLines()) {
            String str = rowLine ? ROW_LINE : EMPTY_LINE;
            stringBuilder.append(str);
            stringBuilder.append(COL_LINE);
        }
        System.out.println(stringBuilder.toString());
    }

}
