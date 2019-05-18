package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {
    private final static int MAX = 5;
    private final static boolean TRUE = true;
    private final static boolean FALSE = false;

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

    @Test
    void 왼쪽으로_움직일_경우() {
        Position position = new Position(1, MAX);
        position.move(Direction.of(TRUE, FALSE));
        assertThat(position).isEqualTo(new Position(0, MAX));
    }

    @Test
    void 오른쪽으로_움직일_경우() {
        Position position = new Position(1, MAX);
        position.move(Direction.of(FALSE, TRUE));
        assertThat(position).isEqualTo(new Position(2, MAX));
    }

    @Test
    void 움직이지_않을_경우() {
        Position position = new Position(1, MAX);
        position.move(Direction.of(FALSE, FALSE));
        assertThat(position).isEqualTo(new Position(1, MAX));
    }
}
