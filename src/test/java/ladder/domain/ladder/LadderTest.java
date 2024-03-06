package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private final RandomPointsGenerator firstLevelPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.ON, Point.OFF, Point.ON, Point.OFF);
        }
    };

    private final RandomPointsGenerator secondLevelPointsGenerator = new RandomPointsGenerator() {
        @Override
        public List<Point> generate(int size) {
            return List.of(Point.OFF, Point.ON, Point.OFF, Point.OFF);
        }
    };

    @Test
    @DisplayName("사다리를 연속으로 탄다.")
    void ride_StartPosition_ResultPosition() {
        // given
        Line line1 = new Line(firstLevelPointsGenerator.generate(4));
        Line line2 = new Line(secondLevelPointsGenerator.generate(4));

        Ladder ladder = new Ladder(List.of(line1, line2));
        int startPosition = 1;

        // when
        int resultPosition = ladder.ride(startPosition);

        // then
        assertThat(resultPosition).isEqualTo(0);
    }
}
