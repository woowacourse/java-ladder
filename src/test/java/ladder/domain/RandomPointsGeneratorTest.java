package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomPointsGeneratorTest {

    @Test
    @DisplayName("사다리 라인은 겹치지 않는다.")
    void pointsNotSequenceDoubleOnTest() {
        // given
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator();

        // when
        List<Point> points = randomPointsGenerator.generate(3);

        // then
        assertThat(points).doesNotContainSequence(Point.ON, Point.ON);
    }

    @Test
    @DisplayName("사다리는 최소 하나의 ON을 포함한다.")
    void pointsHasAtLeastOneOn() {
        // given
        RandomPointsGenerator randomPointsGenerator = new RandomPointsGenerator();

        // when
        List<Point> points = randomPointsGenerator.generate(3);

        // then
        assertThat(points).doesNotContainSequence(Point.ON, Point.ON);
    }
}
