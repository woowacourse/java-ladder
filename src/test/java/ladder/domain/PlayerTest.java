package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    private Line line;

    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
        Point first = Point.first(true);
        Point next = first.next(false);
        line = new Line(Arrays.asList(first, next, next.last()));
    }

    @Test
    void moveRightTest() {
        Player p = new Player(new PlayerName("pobi"), new Position(0));
        assertThat(p.moveOn(line)).isEqualTo(new Player(new PlayerName("pobi"), new Position(1)));
    }

    @Test
    void moveStraightTest() {
        Player p = new Player(new PlayerName("pobi"), new Position(2));
        assertThat(p.moveOn(line)).isEqualTo(new Player(new PlayerName("pobi"), new Position(2)));
    }

    @Test
    void moveLeftTest() {
        Player p = new Player(new PlayerName("pobi"), new Position(1));
        assertThat(p.moveOn(line)).isEqualTo(new Player(new PlayerName("pobi"), new Position(0)));
    }
}
