package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void nameOverTest() {
        assertThrows(RuntimeException.class, () -> new Player("123456", new Position(0)));
    }

    @Test
    void nameLowerTest() {
        assertThrows(RuntimeException.class, () -> new Player("", new Position(0)));
    }

    @Test
    void nameNullTest() {
        assertThrows(RuntimeException.class, () -> new Player(null, new Position(0)));
    }
}
