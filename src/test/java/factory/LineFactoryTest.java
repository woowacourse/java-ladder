package factory;

import domain.Line;
import domain.Point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFactoryTest {

    @DisplayName("사다리 높이와 사람 수를 입력 받아 라인을 생성한다.")
    @Test
    void generateLine() {
        int maxPoint = 5;
        Line line = LineFactory.of(maxPoint);
        assertThat(line.getPoints().size())
                .isEqualTo(maxPoint);
    }

    @DisplayName("true인 Point가 연속되어 생성되지 않는다.")
    @RepeatedTest(5)
    void generateNotContinuousTrue() {
        int maxPoint = 5;
        Line line = LineFactory.of(maxPoint);
        Point previousPoint = line.getPointAt(0);

        for (int pointIndex = 1; pointIndex < line.getPoints().size(); pointIndex++) {
            if (previousPoint == Point.EXIST) {
                assertThat(line.getPointAt(pointIndex)).isEqualTo(Point.NOT_EXIST);
            }
            previousPoint = line.getPointAt(pointIndex);
        }
    }

}
