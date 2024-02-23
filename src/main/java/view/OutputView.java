package view;

import java.util.List;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "실행결과";

    public void printResult(List<String> names, List<String> lines) {
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
    }

    private void printPlayers(List<String> names) {
        System.out.println(formatNames(names));
    }

    private void printLadder(int paddingSize, List<String> lines) {
        for (String line : lines) {
            System.out.println(" ".repeat(paddingSize) + line);
        }
    }

    private String formatNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s ", names.get(0)));

        for (String name : names.subList(1, names.size() - 1)) {
            stringBuilder.append(String.format("%6s", name));
        }

        String lastPlayer = names.get(names.size() - 1);
        stringBuilder.append(String.format("%5s", lastPlayer));
        return stringBuilder.toString();
    }
}
