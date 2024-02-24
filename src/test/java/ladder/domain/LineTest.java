package ladder.domain;

import ladder.util.PointsGenerator;
import ladder.util.RandomPointsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("라인에 사람의 수 - 1만큼 좌표를 생성한다.")
    void createLine() {
        // given
        int personCount = 5;

        // when
        Line line = new Line(personCount, new RandomPointsGenerator());
        int pointsSize = line.getPoints().size();

        // then
        assertThat(pointsSize).isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("좌표가 하나 이상 사용되어야 한다.")
    void createAllUnusedPoints() {
        // given
        int personCount = 5;
        PointsGenerator randomPointsGenerator = new RandomPointsGenerator() {
            @Override
            public List<Point> generate(int size) {
                return List.of(Point.UNUSED, Point.UNUSED, Point.UNUSED, Point.UNUSED);
            }
        };

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, randomPointsGenerator));
    }

    @Test
    @DisplayName("좌표가 연속적으로 사용되어서는 안 된다.")
    void createConsecutiveUsage() {
        // given
        int personCount = 5;
        PointsGenerator randomPointsGenerator = new RandomPointsGenerator() {
            @Override
            public List<Point> generate(int size) {
                return List.of(Point.USED, Point.USED, Point.UNUSED, Point.UNUSED);
            }
        };

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, randomPointsGenerator));
    }
}
