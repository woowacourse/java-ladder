package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;
import utils.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    @DisplayName("인자값으로 받은 numberOfPeople -1 개 만큼의 Point를 가진다")
    @Test
    void create_points_by_number_of_people_minus_1() {
        int numberOfPeople = 3;
        Line line = Line.create(3, new RandomNumberGenerator());

        List<Point> points = line.getPoints();

        assertThat(points.size()).isEqualTo(numberOfPeople - 1);
    }

    @DisplayName("Point 들은 연속된 PASSABLE 을 가질 수 없다.")
    @Test
    void points_can_not_have_two_consecutive_PASSABLE() {
        int numberOfPeople = 4;
        List<Integer> orderOfNumber = List.of(
                MIN_NUMBER_RETURN_TRUE,
                MIN_NUMBER_RETURN_TRUE,
                MIN_NUMBER_RETURN_TRUE);

        Line line = Line.create(numberOfPeople, new MockNumberGenerator(orderOfNumber));
        List<Point> points = line.getPoints();

        assertThat(points).containsExactly(Point.PASSABLE, Point.BLOCKED, Point.PASSABLE);
    }

    /**
     * 생성자를 통해 특정한 숫자값을 순서대로 반환하는 NumberGenerator
     */
    class MockNumberGenerator implements NumberGenerator {

        private final List<Integer> values;
        private int index = 0;

        public MockNumberGenerator(List<Integer> values) {
            this.values = values;
        }

        @Override
        public int generate() {
            Integer value = values.get(index);
            index++;
            return value;
        }
    }
}
