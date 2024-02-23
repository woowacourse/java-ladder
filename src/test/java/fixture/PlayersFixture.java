package fixture;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import domain.player.Players;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PlayersFixture {
    public static Players 참가자들(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> NameFixture.이름("프린" + i))
                .collect(collectingAndThen(toList(), Players::new));
    }

    public static Players 참가자들(String... names) {
        return Arrays.stream(names)
                .map(NameFixture::이름)
                .collect(collectingAndThen(toList(), Players::new));
    }
}
