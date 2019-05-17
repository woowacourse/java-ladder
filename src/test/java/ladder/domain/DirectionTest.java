package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    void consecutiveTrueTest() {
        assertThrows(RuntimeException.class, () -> {
            new Direction(true, true);
        });
    }

    @Test
    void leftTest() {
        Direction left = new Direction(true, false);
        assertThat(left.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void rightTest() {
        Direction right = new Direction(false, true);
        assertThat(right.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void straightTest() {
        Direction straight = new Direction(false, false);
        assertThat(straight.move()).isEqualTo(Direction.STRAIGHT);
    }

    @Test
    void firstNoLeftTest() {
        Direction first = Direction.first(true);
        assertThat(first.move()).isNotEqualTo(Direction.LEFT);
        first = Direction.first(false);
        assertThat(first.move()).isNotEqualTo(Direction.LEFT);
    }

    @Test
    void lastNoRightTest() {
        Direction direction = Direction.first(true);
        assertThat(direction.last().move()).isNotEqualTo(Direction.RIGHT);
        direction = Direction.first(false);
        assertThat(direction.last().move()).isNotEqualTo(Direction.RIGHT);
    }
}
