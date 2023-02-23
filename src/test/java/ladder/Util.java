package ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;

public class Util {
    public static List<Prize> createResults(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> new Prize(String.valueOf(value)))
                .collect(toList());
    }

    public static Players createPlayers(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> new Player(String.valueOf(value)))
                .collect(collectingAndThen(toList(), Players::new));
    }
}
