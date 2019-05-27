package ladderGameSolo;

import ladderGameSolo.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    private static final int MAX = 3;

    @Test
    void underZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(-1, MAX);
        });
    }

    @Test
    void overlapMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(4, MAX);
        });
    }

    @Test
    void isUnderMaxPosition() {
        Position position = new Position(3, 4);
        assertThat(position.isLessThanMax()).isFalse();
    }
}
