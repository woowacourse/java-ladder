package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("라인의 포인트 개수는 19를 넘을 수 없다.")
    @Test
    void pointNotMoreThan19() {
        assertThatThrownBy(() -> new Line(20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0보다 작을 수 없다.")
    @Test
    void pointNotLessThan0() {
        assertThatThrownBy(() -> new Line(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("사다리의 포인트가 true인 지점은 연속될 수 없다.")
    @Test
    void pointNotContinuous() {
        int pointSize = 5;
        Line line = new Line(pointSize);
        for (int i = 0; i < pointSize - 1; i++) {
            Point left = line.getPointAt(i);
            Point right = line.getPointAt(i + 1);
            assertThat(left.isExist() && right.isExist()).isFalse();
        }
    }

    @DisplayName("사다리는 포인트를 생성하여 갖는다.")
    @Test
    void generatePoints() {
        Line line = new Line(10);
        assertThat(line.getPoints().size()).isEqualTo(10);
    }
}
