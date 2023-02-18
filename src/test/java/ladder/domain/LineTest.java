package ladder.domain;

import static ladder.domain.Bar.IMMOVABLE;
import static ladder.domain.Bar.MOVABLE;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.RandomGenerator;
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
    @DisplayName("bar가 연속되지 않게 Line을 생성한다")
    void shouldDeterminedValuesWhenCreateLine() {
        // given
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, true));
        // when
        Line line = new Line(3, new DeterminedRandomGenerator(determinedBars));
        // then
        assertThat(line.getBars()).containsExactly(MOVABLE, IMMOVABLE, MOVABLE);
    }

    static class DeterminedRandomGenerator implements RandomGenerator<Boolean> {
        private final List<Boolean> bars;

        public DeterminedRandomGenerator(List<Boolean> bars) {
            this.bars = bars;
        }

        @Override
        public Boolean generate() {
            return bars.remove(0);
        }
    }
}
