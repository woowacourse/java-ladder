package ladder.domain;

import static ladder.domain.Bar.IMMOVABLE;
import static ladder.domain.Bar.MOVABLE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @Test
    @DisplayName("bar를 3개를 생성한다")
    void should3barWhenCreateLine() {
        Line line = Line.generate(3, new RandomBooleanGenerator());

        assertThat(line.getBars()).hasSize(3);
    }

    @Test
    @DisplayName("bar가 연속되지 않게 Line을 생성한다")
    void shouldDeterminedValuesWhenCreateLine() {
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, true));

        Line line = Line.generate(3, new DeterminedBooleanGenerator(determinedBars));

        assertThat(line.getBars()).containsExactly(MOVABLE, IMMOVABLE, MOVABLE);
    }

    /*
     |-----|     |-----|     |
     */
    @ParameterizedTest
    @CsvSource(value = {"0:RIGHT", "1:LEFT", "2:RIGHT", "3:LEFT", "4:NONE"}, delimiter = ':')
    @DisplayName("position의 기준으로 bar의 위치를 반환한다")
    void shouldReturnDirectionWhenGetPosition(int currentPosition, Direction expect) {
        List<Boolean> determinedBars = new ArrayList<>(List.of(true, true, false));
        Line line = Line.generate(4, new DeterminedBooleanGenerator(determinedBars));

        Direction direction = line.getDirection(new Position(currentPosition));

        assertThat(direction).isEqualTo(expect);
    }
}
