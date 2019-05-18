package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    private final static int MAX = 5;

    @Test
    void 각_포지션_생성() {
        Position position = new Position(1, MAX);
        assertThat(position).isEqualTo(new Position(1, MAX));
    }

    @Test
    void 음수인_포지션인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(-1, MAX);
        });
    }

    @Test
    void 최대_포지션_이상인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(MAX, MAX);
        });
    }
}
