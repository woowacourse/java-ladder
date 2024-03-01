package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("첫번째 지점에서 왼쪽으로 연결 됐을 때 예외가 발생한다")
    void firstPoint() {
        assertThatCode(() -> new Line(new Point(true, false), Point.CLOSE)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 지점에서 오른쪽으로 연결 됐을 때 예외가 발생한다")
    void lastPoint() {
        assertThatCode(() -> new Line(Point.CLOSE, new Point(false, true))).isInstanceOf(
                IllegalArgumentException.class);
    }
}
