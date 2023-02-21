package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Step;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printResult(List<Player> players, List<Line> lines) {
        System.out.println("실행결과");
        printNames(players);
        printLadder(lines);
    }

    private static void printNames(List<Player> players) {
        String result = players.stream()
                .map(Player::getName)
                .map(name -> String.format("%-5s", name))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void printLadder(List<Line> lines) {
        String result = lines.stream()
                .map(line -> "|" + line.getSteps().stream()
                        .map(Step::getShape)
                        .collect(Collectors.joining("|")) + "|")
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(result);
    }
}
