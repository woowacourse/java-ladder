package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    @DisplayName("점을 올바르게 생성한다.")
    void creationTest() {
        assertDoesNotThrow(() -> new Point(Direction.LEFT));
    }

    @Test
    @DisplayName("점의 방향에 따라 인덱스를 올바르게 계산한다.")
    void indexCalculateTest() {
        // given
        Point straightPoint = new Point(Direction.STRAIGHT);
        Point leftPoint = new Point(Direction.LEFT);
        Point rightPoint = new Point(Direction.RIGHT);
        // when, then
        assertThat(straightPoint.move(1)).isEqualTo(1);
        assertThat(leftPoint.move(1)).isEqualTo(0);
        assertThat(rightPoint.move(1)).isEqualTo(2);
    }
}
