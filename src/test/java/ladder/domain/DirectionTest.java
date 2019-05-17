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
        assertThat(left.move()).isEqualTo(-1);
    }

    @Test
        void rightTest() {
        Direction right = new Direction(false, true);
        assertThat(right.move()).isEqualTo(1);
    }
}
