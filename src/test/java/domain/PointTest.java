package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("가로라인이 추가되지 않은 경우")
    void test() {
        Point down = new Point(Direction.DOWN);

        assertThat(down.isDown()).isTrue();
    }

    @Test
    @DisplayName("가로라인이 추가된 경우")
    void test1() {
        Point left = new Point(Direction.LEFT);
        Point right = new Point(Direction.RIGHT);

        assertThat(left.isDown()).isFalse();
        assertThat(right.isDown()).isFalse();
    }
}
