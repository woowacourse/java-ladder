package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
    }

    @Test
    void goDownTest() {
        List<Player> p = Arrays.asList(new Player(new PlayerName("pobi"), new Position(0)), new Player(new PlayerName("crong"), new Position(1)), new Player(new PlayerName("honux"), new Position(2)));
        Players players = new Players(p);
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        p = Arrays.asList(new Player(new PlayerName("pobi"), new Position(1)), new Player(new PlayerName("crong"), new Position(0)), new Player(new PlayerName("honux"), new Position(2)));
        Players movedPlayers = new Players(p);
        assertThat(players.goDown(line)).isEqualTo(movedPlayers);
    }
}
