package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @BeforeEach
    void setup() {
        Position.MAX = 2;
    }

    @Test
    void moveRightTest() {
        Player p = new Player(new Position(1));
        assertThat(p.move(Direction.first(false).next(true))).isEqualTo(new Position(2));
    }

    @Test
    void moveStraightTest() {
        Player p = new Player(new Position(1));
        assertThat(p.move(Direction.first(false).next(false))).isEqualTo(new Position(1));
    }

    @Test
    void moveLeftTest() {
        Player p = new Player(new Position(1));
        assertThat(p.move(Direction.first(true).next(false))).isEqualTo(new Position(0));
    }
}
