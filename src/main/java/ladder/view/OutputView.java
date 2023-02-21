package ladder.view;

import static java.util.stream.Collectors.joining;

import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Step;
import ladder.domain.strategy.linestrategy.Result;
import java.util.List;

public class OutputView {

    public static void printLadder(List<Player> players, List<Line> lines, List<Result> results) {
        System.out.println(System.lineSeparator() + "사다리 결과" + System.lineSeparator());
        printNames(players);
        printLadder(lines);
        printResults(results);
    }

    private static void printNames(List<Player> players) {
        String result = players.stream()
                .map(Player::getName)
                .map(name -> String.format("%-5s", name))
                .collect(joining(" "));
        System.out.println(result);
    }

    private static void printLadder(List<Line> lines) {
        String result = lines.stream()
                .map(line -> "|" + line.getSteps().stream()
                        .map(Step::getShape)
                        .collect(joining("|")) + "|")
                .collect(joining(System.lineSeparator()));
        System.out.println(result);
    }

    private static void printResults(List<Result> results) {
        String message = results.stream()
                .map(Result::getResult)
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
        System.out.println(message);
    }

    public static void printSingleResult(String result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(result);
    }

    public static void printAllResult(List<String> players, List<String> allResult) {
        StringBuilder stringBuilder = new StringBuilder(System.lineSeparator() + "실행 결과" + System.lineSeparator());
        for (int i = 0; i < players.size(); i++) {
            stringBuilder.append(players.get(i) + " : " + allResult.get(i) + System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
