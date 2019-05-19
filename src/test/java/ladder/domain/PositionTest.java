package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class PositionTest {
    @Test
    void create_true_true_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Position.add(true, true);
        });
    }

    @Test
    void create_시작() {
        assertThat(Position.start(true)).isEqualTo(Position.add(false, true));
    }

    @Test
    void create_끝() {
        assertThat(Position.end(true)).isEqualTo(Position.add(true, false));
    }

    @Test
    void move_오른쪽_이동() {
        Position position = Position.add(false, true);
        assertThat(position.move(1)).isEqualTo(2);
    }

    @Test
    void move_왼쪽_이동() {
        Position position = Position.add(true, false);
        assertThat(position.move(2)).isEqualTo(1);
    }

    @Test
    void move_직선_이동() {
        Position position = Position.add(false, false);
        assertThat(position.move(2)).isEqualTo(2);
    }
}
