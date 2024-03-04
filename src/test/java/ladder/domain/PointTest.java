package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("뒤쪽으로 이동한다.")
    @Test
    void moveBackward() {
        // given
        Point point = new Point(Direction.BACKWARD);
        Index index = new Index(1);

        // when
        Index expected = point.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(0);
    }

    @DisplayName("앞쪽으로 이동한다.")
    @Test
    void moveForward() {
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
    void moveStay() {
        // given
        Point point = new Point(Direction.STAY);
        Index index = new Index(1);

        // when
        Index expected = point.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(1);
    }
}
