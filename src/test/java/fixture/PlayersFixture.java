package fixture;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.player.Players;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PlayersFixture {
    public static Players 참가자들(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> "프린" + i)
                .collect(collectingAndThen(toList(), Players::from));
    }

    public static Players 참가자들(String... names) {
        return Players.from(Arrays.asList(names));
    }
}
