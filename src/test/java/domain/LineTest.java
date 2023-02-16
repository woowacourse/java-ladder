package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("라인의 포인트 개수는 20을 넘을 수 없다.")
    @Test
    void pointNotMoreThan20() {
        int pointSize = 21;
        assertThatThrownBy(() -> new Line(pointSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 포인트 개수는 0이하일 수 없다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void pointNotLessThan1(int pointSize) {
        assertThatThrownBy(() -> new Line(pointSize))
                .isInstanceOf(IllegalArgumentException.class);
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
