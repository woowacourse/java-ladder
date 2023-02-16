package laddergame;

import laddergame.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderFormTest {
    @Test
    void joinUnitsFrom() {
        Line line = new Line(List.of(true, false));
        Line line2 = new Line(List.of(false, true));
        List<Line> lines = List.of(line, line2);
        String ladderForm = LadderForm.joinUnitsFrom(lines);
        Assertions.assertThat(ladderForm).contains("|-----|     |\n|     |-----|");
    }
}