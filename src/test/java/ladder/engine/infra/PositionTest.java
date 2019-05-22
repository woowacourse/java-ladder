package ladder.engine.infra;

import ladder.engine.infra.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    private static final int MAX = 3;

    @Test
    public void isFirst() {
        Position position = new Position(0, MAX);
        assertThat(position.isFirst()).isTrue();
    }

    @Test
    public void isLast() {
        Position position = new Position(MAX - 1, MAX);
        assertThat(position.isLast()).isTrue();
    }

    @Test
    public void underZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(-1, MAX);
        });
    }

    @Test
    public void overMax() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(MAX, MAX);
        });
    }

    @Test
    public void moveNext() {
        assertThat(new Position(0, MAX).moveNext())
                .isEqualTo(new Position(1, MAX));
    }

    @Test
    public void movePrevious() {
        assertThat(new Position(1, MAX).movePrevious())
                .isEqualTo(new Position(0, MAX));
    }
}
