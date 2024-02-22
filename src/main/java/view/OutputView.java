package view;

import java.util.List;
import model.Line;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%n%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "실행결과";

    public void printResult(List<String> names, List<Line> lines) {
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
    }

    private void printPlayers(List<String> names) {
        String value = Formatter.formatPlayers(names);
        System.out.println(value);
    }

    private void printLadder(int paddingSize, List<Line> lines) {
        String value = Formatter.formatLadder(paddingSize, lines);
        System.out.printf(value);
    }
}
