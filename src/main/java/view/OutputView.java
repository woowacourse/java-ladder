package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "사다리 결과";

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
        stringBuilder.append(formatFirstName(names));
        stringBuilder.append(formatMiddleNames(names));
        stringBuilder.append(formatLastName(names));
        return stringBuilder.toString();
    }

    private String formatLastName(List<String> names) {
        String lastPlayer = names.get(names.size() - 1);
        return String.format("%6s", lastPlayer);
    }

    private String formatMiddleNames(List<String> names) {
        return names.subList(1, names.size() - 1)
                .stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
    }

    private String formatFirstName(List<String> names) {
        return String.format("%s ", names.get(0));
    }
}
