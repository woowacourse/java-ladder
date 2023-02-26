package ladder;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Prize;
import ladder.domain.Step;

public class Util {
    public static List<Prize> createPrizes(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> new Prize(String.valueOf(value)))
                .collect(toList());
    }

    public static List<Prize> createPrizes(String... prizes) {
        return Arrays.stream(prizes)
                .map(Prize::new)
                .collect(toList());
    }

    public static List<Player> createPlayers(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> new Player(String.valueOf(value)))
                .collect(toList());
    }

    public static List<Player> createPlayers(String... names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(toList());
    }

    public static List<Line> createLines(int height, int width) {
        List<Step> steps = createEmptySteps(width);
        return createLines(height, steps);
    }

    public static List<Line> createLines(int height, List<Step> steps) {
        return IntStream.range(0, height)
                .mapToObj(value -> new Line(steps))
                .collect(toList());
    }

    private static List<Step> createEmptySteps(int width) {
        return IntStream.range(0, width - 1)
                .mapToObj(value -> Step.EMPTY)
                .collect(toList());
    }
}
