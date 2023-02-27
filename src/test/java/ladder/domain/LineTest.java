package ladder.domain;


import static ladder.domain.Bar.IMMOVABLE;
import static ladder.domain.Bar.MOVABLE;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BooleanGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @Test
    @DisplayName("bar를 생성한다")
    void should3barWhenCreateLine() {
        // given
        // when
        Line line = new Line(3);
        // then
        assertThat(line.getBars()).hasSize(5);
    }

    @Test
    @DisplayName("0 이하 크기의 bar를 생성하면 예외를 발생시킨다")
    void shouldThrowExceptionWhenInputBelow0() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Line(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한 Line의 Bar는 1개 이상이어야 합니다.");
    }

    @Test
    @DisplayName("bar가 연속되지 않게 Line을 생성한다")
    void shouldDeterminedValuesWhenCreateLine() {
        // given
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, true));
        // when
        Line line = new Line(3, new DeterminedBooleanGenerator(determinedBars));
        // then
        assertThat(line.getBars()).containsExactly(IMMOVABLE, MOVABLE, IMMOVABLE, MOVABLE, IMMOVABLE);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2", "3:4", "4:3"}, delimiter = ':')
    @DisplayName("위치를 입력받아 Line에 맞게 움직인다.")
    void shouldMoveTo1WhenStartAT0(int startColumnIndex, int endColumnIndex) {
        // given
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, false, true));
        Line line = new Line(4, new DeterminedBooleanGenerator(determinedBars));
        Location location = new Location(startColumnIndex);
        // when
        line.move(location);
        // then
        assertThat(line.getBars()).containsExactly(IMMOVABLE, MOVABLE, IMMOVABLE, IMMOVABLE, MOVABLE, IMMOVABLE);
        assertThat(location.getColumnIndex()).isEqualTo(endColumnIndex);
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
