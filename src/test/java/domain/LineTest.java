package domain;

import factory.LineFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private static final RandomBasedStrategy randomBasedStrategy = new RandomBasedStrategy();

    @DisplayName("Point로 구성된 라인을 생성할 수 있다.")
    @Test
    void generateLine() {
        List<Point> points = List.of(Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST, Point.NOT_EXIST);
        assertThat(new Line(points).getPoints())
                .contains(Point.EXIST, Point.NOT_EXIST);
    }

    @DisplayName("라인의 포인트 개수는 19를 넘을 수 없다.")
    @Test
    void pointNotMoreThan19() {
        assertThatThrownBy(() -> LineFactory.of(20, randomBasedStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0보다 작을 수 없다.")
    @Test
    void pointNotLessThan0() {
        assertThatThrownBy(() -> LineFactory.of(-1, randomBasedStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0이상 19이하이다.")
    @ValueSource(ints = {0, 10, 19})
    @ParameterizedTest
    void pointSizeTest(int pointSize) {
        Line line = LineFactory.of(pointSize, randomBasedStrategy);
        assertThat(line.getPoints().size()).isEqualTo(pointSize);
    }

    @DisplayName("사다리의 포인트가 true인 지점은 연속될 수 없다.")
    @Test
    void pointNotContinuous() {
        int pointSize = 5;
        Line line = LineFactory.of(pointSize, randomBasedStrategy);
        for (int i = 0; i < pointSize - 1; i++) {
            Point left = line.getPointAt(i);
            Point right = line.getPointAt(i + 1);
            assertThat(left.isExist() && right.isExist()).isFalse();
        }

    }

}
