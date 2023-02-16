package laddergame;

import laddergame.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.TestDummy.PARTICIPANTS_SIZE_2;
import static org.assertj.core.api.Assertions.assertThat;

class LadderFormTest {
    @Test
    void joinUnitsFrom() {
        Line line = new Line(List.of(true));
        Line line2 = new Line(List.of(true));
        List<Line> lines = List.of(line, line2);
        List<String> names = PARTICIPANTS_SIZE_2.getNames();
        String ladderForm = LadderForm.joinUnitsFrom(names, lines);
        System.out.println(ladderForm);
        assertThat(ladderForm).contains(" rosie hyena\n     |-----|\n     |-----|");
    }
}