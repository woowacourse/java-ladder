package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("bar를 3개를 생성한다")
    void should3barWhenCreateLine() {
        // given
        // when
        Line line = new Line(3);
        // then
        assertThat(line.getBars()).hasSize(3);

    }

    @Test
    @DisplayName("bar를 정해진 값으로 생성한다")
    void shouldDeterminedValuesWhenCreateLine() {
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Line line = new Line(3, new DeterminedBooleanGenerator(determinedBars));

        assertThat(line.getBars()).containsExactly(true, false, true);
    }

    static class DeterminedBooleanGenerator implements BooleanGenerator {

        private final List<Boolean> bars;

        public DeterminedBooleanGenerator(List<Boolean> bars) {
            this.bars = bars;
        }

        @Override
        public boolean generate() {
            return bars.remove(0);
        }
    }
}
