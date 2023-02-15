package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    @DisplayName("주어진 숫자에 따라 적합한 points를 가진 Line을 생성한다.")
    @Test
    void create() {
        List<Integer> orderOfNumber = List.of(
                MIN_NUMBER_RETURN_TRUE - 1,
                MIN_NUMBER_RETURN_TRUE,
                MIN_NUMBER_RETURN_TRUE - 1);
        Line line = Line.create(3, new MockNumberGenerator(orderOfNumber));

        List<Point> points = line.getPoints();

        assertThat(points).containsExactly(Point.BLOCKED, Point.PASSABLE, Point.BLOCKED);
    }

    @DisplayName("통과 가능한 포인트가 없는 Line을 생성한다")
    @Test
    void create_line_have_no_point() {
        Line line = Line.createWithoutPassablePoint(3);

        List<Point> points = line.getPoints();

        assertThat(points).containsExactly(Point.BLOCKED, Point.BLOCKED, Point.BLOCKED);
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
