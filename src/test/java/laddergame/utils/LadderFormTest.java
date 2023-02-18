package laddergame.utils;

import laddergame.domain.Line;
import laddergame.fixture.ParticipantsFixture;
import laddergame.view.LadderForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 형식")
class LadderFormTest {
    @DisplayName("생성한다.")
    @Test
    void joinUnitsFrom() {
        final Line line = new Line(List.of(true));
        final Line line2 = new Line(List.of(true));
        final List<Line> lines = List.of(line, line2);
        final List<String> names = ParticipantsFixture.getParticipantsSize2().getNames();
        final String ladderForm = LadderForm.joinUnitsFrom(names, lines);
        assertThat(ladderForm).contains(" rosie hyena\n     |-----|\n     |-----|");
    }
}