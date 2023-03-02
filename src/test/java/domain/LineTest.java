package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

class LineTest {

    public static final int PASSABLE_THRESHOLDS = 4;

    @DisplayName("인자값으로 받은 numberOfPeople -1 개 만큼의 Point를 가진다")
    @Test
    void create_points_by_number_of_people_minus_1() {
        int numberOfPeople = 3;
        Line line = Line.create(3, new RandomNumberGenerator());

        List<Point> points = line.points();

        assertThat(points.size()).isEqualTo(numberOfPeople - 1);
    }

    @DisplayName("Point 들은 연속된 PASSABLE 을 가질 수 없다.")
    @Test
    void points_can_not_have_two_consecutive_PASSABLE() {
        int numberOfPeople = 4;
        List<Integer> orderOfNumber = List.of(
                PASSABLE_THRESHOLDS,
                PASSABLE_THRESHOLDS,
                PASSABLE_THRESHOLDS);

        Line line = Line.create(numberOfPeople, new MockNumberGenerator(orderOfNumber));
        List<Point> points = line.points();

        assertThat(points).containsExactly(Point.PASSABLE, Point.BLOCKED, Point.PASSABLE);
    }


}
