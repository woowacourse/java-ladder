package ladder.view;

import ladder.domain.DrawResult;
import ladder.domain.Ladder;
import ladder.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

import static ladder.view.constants.OutputViewMessages.*;

public class OutputView {

    public static void printLadder(Ladder ladder, List<Player> players, List<DrawResult> drawResults) {
        System.out.println(PAINT_LADDER_MESSAGE);

        System.out.println(players.stream()
                .map(player -> String.format(DEFAULT_LENGTH_FORMAT, player.getName()))
                .collect(Collectors.joining()));

        System.out.println(ladder.toString());

        System.out.println(drawResults.stream()
                .map(drawResult -> String.format(DEFAULT_LENGTH_FORMAT, drawResult.getResult()))
                .collect(Collectors.joining()));
    }

    public static void printResult(String result) {
        System.out.println(PRINT_RESULT_MESSAGE);
        System.out.println(result);
    }
}