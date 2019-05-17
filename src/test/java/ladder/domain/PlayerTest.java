package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player p;

    @BeforeEach
    void setup() {
        Position.MAX = 2;
        p = new Player("pobi", new Position(1));
    }

    @Test
    void moveRightTest() {
        assertThat(p.move(Direction.first(false).next(true))).isEqualTo(new Player("pobi", new Position(2)));
    }

    @Test
    void moveStraightTest() {
        assertThat(p.move(Direction.first(false).next(false))).isEqualTo(new Player("pobi", new Position(1)));
    }

    @Test
    void moveLeftTest() {
        assertThat(p.move(Direction.first(true).next(false))).isEqualTo(new Player("pobi", new Position(0)));
    }
}
