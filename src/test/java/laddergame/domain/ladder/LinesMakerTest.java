package laddergame.domain.ladder;

import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesMakerTest {

    private LinesMaker linesMaker;

    @BeforeEach
    void setUp() {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        linesMaker = LinesMaker.create(booleanGenerator);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("컬렉션의 크기가 heightNumber와 같은지 확인한다")
    void is_same_size_as_height_number(final int heightNumber) {
        //given
        final int rungCount = 5;
        List<Line> lines = linesMaker.makeLines(heightNumber, rungCount);

        //when
        int actualSize = lines.size();

        //then
        assertThat(actualSize).isEqualTo(heightNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("컬렉션 요소의 크기가 rungCount와 같은지 확인한다")
    void is_same_element_size_as_rung_count(final int rungCount) {
        //given
        final int heightNumber = 5;
        List<Line> lines = linesMaker.makeLines(heightNumber, rungCount);

        //when
        int actualSize = getFirstLineSize(lines);

        //then
        assertThat(actualSize).isEqualTo(rungCount);
    }

    private int getFirstLineSize(final List<Line> lines) {
        Line firstLine = lines.get(0);
        List<Rung> rungs = firstLine.getRungs();
        return rungs.size();
    }
}
