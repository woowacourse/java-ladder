package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("주어진 숫자에 따라 적합한 points를 가진 Line을 생성한다.")
    @Test
    void create() {
        Line line = Line.create(3, new MockNumberGenerator(List.of(3,4,3)));
        List<Boolean> points = line.getPoints();
        assertThat(points).containsExactly(false,true,false);
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