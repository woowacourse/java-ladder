package domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private PointGenerator pointGenerator;

    @BeforeEach
    void before() {
        pointGenerator = new RandomPointGenerator();
    }

    @DisplayName("라인의 포인트 개수는 19를 넘을 수 없다.")
    @Test
    void pointNotMoreThan19() {
        assertThatThrownBy(() -> Line.of(20, pointGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0보다 작을 수 없다.")
    @Test
    void pointNotLessThan0() {
        assertThatThrownBy(() -> Line.of(-1, pointGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0이상 19이하이다.")
    @ValueSource(ints = {0, 10, 19})
    @ParameterizedTest
    void pointSizeTest(int pointSize) {
        Line line = Line.of(pointSize, pointGenerator);
        assertThat(line.getPoints().size()).isEqualTo(pointSize);
    }

    @DisplayName("사다리의 포인트가 true인 지점은 연속될 수 없다.")
    @Test
    void pointNotContinuous() {
        int pointSize = 5;
        Line line = Line.of(pointSize, pointGenerator);
        for (int i = 0; i < pointSize - 1; i++) {
            Point left = line.getPointAt(i);
            Point right = line.getPointAt(i + 1);
            assertThat(left.isExist() && right.isExist()).isFalse();
        }
    }

}
