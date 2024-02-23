package view;

import java.util.List;
import model.Line;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "실행결과";

    public void printResult(List<String> names, List<Line> lines) {
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
    }

    private void printPlayers(List<String> names) {
        System.out.println(formatNames(names));
    }

    private void printLadder(int paddingSize, List<Line> lines) {
        String value = Formatter.formatLadder(paddingSize, lines);
        System.out.printf(value);
    }

    private String formatNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        // 첫번째
        stringBuilder.append(String.format("%s ", names.get(0)));

        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(String.format("%6s", name));
        }
        String lastPlayer = names.get(names.size() - 1);
        stringBuilder.append(String.format("%5s", lastPlayer));
        return stringBuilder.toString();
    }
}
