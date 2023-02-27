package ladder.view;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class OutputView {

    public static void printLadder(List<String> names, List<List<String>> ladder, List<String> results) {
        System.out.println(System.lineSeparator() + "사다리 결과" + System.lineSeparator());
        printNames(names);
        printLadder(ladder);
        printResults(results);
    }

    private static void printNames(List<String> names) {
        String result = names.stream()
                .map(name -> String.format("%-5s", name))
                .collect(joining(" "));
        System.out.println(result);
    }

    private static void printLadder(List<List<String>> ladder) {
        String result = ladder.stream()
                .map(steps -> "|" + steps.stream()
                        .collect(joining("|")) + "|")
                .collect(joining(System.lineSeparator()));
        System.out.println(result);
    }

    private static void printResults(List<String> results) {
        String outputResult = results.stream()
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
        System.out.println(outputResult);
    }

    public static void printSingleResult(String result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(result);
    }

    public static void printAllResult(List<String> players, List<String> allResult) {
        System.out.print(System.lineSeparator() + "실행 결과" + System.lineSeparator());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            stringBuilder.append(players.get(i)).append(" : ").append(allResult.get(i)).append(System.lineSeparator());
        }
        System.out.print(stringBuilder);
    }
}
