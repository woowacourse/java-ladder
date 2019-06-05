package ladderGameSolo;

import ladderGameSolo.domain.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DirectionTest {
    @Test
    void move_left() {
        Direction direction = new Direction(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_right() {
        Direction direction = new Direction(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_none() {
        Direction direction = new Direction(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void 모두_true_일때() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Direction(true, true);
        });
    }
}
