package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

class LineGeneratorTest {

    private LineGenerator lineGenerator;

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    @DisplayName("인자값으로 받은 width의 개수 만큼의 LinePoint를 가진다")
    @Test
    void create_points_by_input_width() {
        // given
        lineGenerator = new LineGenerator(new RandomNumberGenerator());
        int width = 3;
        Line line = lineGenerator.generate(width);

        // when
        List<LinePoint> points = line.getPoints();

        // then
        assertThat(points.size()).isEqualTo(width);
    }

    @DisplayName("LinePoint 들은 연속된 PASSABLE 을 가질 수 없다.")
    @Test
    void points_can_not_have_two_consecutive_PASSABLE() {
        // given
        lineGenerator = new LineGenerator(() -> MIN_NUMBER_RETURN_TRUE);
        Line line = lineGenerator.generate(3);

        // when
        List<LinePoint> points = line.getPoints();

        // then
        assertThat(points).containsExactly(LinePoint.PASSABLE, LinePoint.BLOCKED, LinePoint.PASSABLE);
    }
}
