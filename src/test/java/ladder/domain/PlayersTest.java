package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @BeforeEach
    void setup() {
        Position.MAX = 2;
    }

    @Test
    void goDownTest() {
        List<Player> p = Arrays.asList(new Player("pobi", new Position(0)), new Player("crong", new Position(1)), new Player("honux", new Position(2)));
        Players players = new Players(p);
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        p = Arrays.asList(new Player("pobi", new Position(1)), new Player("crong", new Position(0)), new Player("honux", new Position(2)));
        Players movedPlayers = new Players(p);
        assertThat(players.goDown(line)).isEqualTo(movedPlayers);
    }
}
