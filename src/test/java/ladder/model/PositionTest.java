package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    private static final int MAX = 3;

    @Test
    void isFirst() {
        Position position = new Position(0, MAX);
        assertThat(position.isFirst()).isTrue();
    }

    @Test
    void isLast() {
        Position position = new Position(MAX - 1, MAX);
        assertThat(position.isLast()).isTrue();
    }

    @Test
    void underZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(-1, MAX);
        });
    }

    @Test
    void overMax() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(MAX, MAX);
        });
    }

    @Test
    void moveNext() {
        assertThat(new Position(0, MAX).moveNext())
                .isEqualTo(new Position(1, MAX));
    }

    @Test
    void movePrevious() {
        assertThat(new Position(1, MAX).movePrevious())
                .isEqualTo(new Position(0, MAX));
    }
}
