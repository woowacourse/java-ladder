package ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;

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

    public static Players createPlayers(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> new Player(String.valueOf(value)))
                .collect(collectingAndThen(toList(), Players::new));
    }

    public static Players createPlayers(String... names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }
}
