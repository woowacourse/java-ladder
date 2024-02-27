package view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import model.Prize;

public class OutputView {
    private static final String FINAL_RESULT_FORMAT = "%s%n%n";
    private static final String FINAL_RESULT_MESSAGE = "사다리 결과";
    private static final String PRIZE_RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORM = "%s : %s%n";

    public void printLadderResult(List<String> names, List<String> lines,
                                  List<Prize> prizes) { //TODO: prize 대신 string 고려
        System.out.printf(FINAL_RESULT_FORMAT, FINAL_RESULT_MESSAGE);
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
        printPrizes(prizes);
    }

    public void printAllPlayerResult(Map<String, String> ladderResult) {
        System.out.println(PRIZE_RESULT_MESSAGE);
        for (Entry<String, String> result : ladderResult.entrySet()) {
            System.out.printf(RESULT_FORM, result.getKey(), result.getValue());
        }
    }

    public void printOnePlayerPrize(String name, String prize) {
        System.out.println(PRIZE_RESULT_MESSAGE);
        System.out.printf(RESULT_FORM, name, prize);
        System.out.println();
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
        System.out.println();
        System.out.println();
    }

    private String formatNames(List<String> names) {
        return formatFirstName(names) + formatMiddleNames(names) + formatLastName(names);
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
