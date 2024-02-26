package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Prize;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "사다리 결과";

    public void printResult(List<String> names, List<String> lines, List<Prize> prizes) { //TODO: prize 대신 string 고려
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
        printPrizes(prizes);
    }

    private void printPlayers(List<String> names) {
        System.out.println(formatNames(names));
    }

    private void printLadder(int paddingSize, List<String> lines) {
        for (String line : lines) {
            System.out.println(" ".repeat(paddingSize) + line);
        }
    }

    private void printPrizes(List<Prize> prizes) {
        for (Prize prize : prizes) {
            System.out.printf(String.format("%-6s", prize.toString()));
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
