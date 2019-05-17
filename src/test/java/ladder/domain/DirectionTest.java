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
    void LeftTest() {
        Direction left = new Direction(true, false);
        assertThat(left.move()).isEqualTo(-1);
    }
}
