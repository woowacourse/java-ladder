package laddergame.utils;

import laddergame.domain.Line;
import laddergame.view.LadderFormGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.PARTICIPANTS_SIZE_2;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 형식")
class LadderFormTest {

    @DisplayName("생성한다.")
    @Test
    void joinUnitsFrom() {
        final Line line = new Line(List.of(true));
        final Line line2 = new Line(List.of(true));
        final List<Line> lines = List.of(line, line2);
        final List<String> names = PARTICIPANTS_SIZE_2.getNames();
        final String ladderFormGenerator = LadderFormGenerator.generate(names, lines);
        assertThat(ladderFormGenerator).contains(" rosie hyena\n     |-----|\n     |-----|");
    }
}