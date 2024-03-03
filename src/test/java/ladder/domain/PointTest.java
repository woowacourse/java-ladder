package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void moveLeft() {
        // given
        Point point = new Point(Direction.BACKWARD);
        Index index = new Index(1);

        // when
        Index expected = point.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(0);
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void moveRight() {
        // given
        Point point = new Point(Direction.FORWARD);
        Index index = new Index(0);

        // when
        Index expected = point.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }

    @DisplayName("그대로 이동한다.")
    @Test
    void moveDown() {
        // given
        Point point = new Point(Direction.STAY);
        Index index = new Index(1);

        // when
        Index expected = point.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }
}
