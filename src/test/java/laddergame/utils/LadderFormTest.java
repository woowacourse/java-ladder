package laddergame.utils;

import laddergame.domain.GameResults;
import laddergame.domain.Line;
import laddergame.domain.Lines;
import laddergame.domain.Names;
import laddergame.fixture.ParticipantsFixture;
import laddergame.fixture.GameResultsFixture;
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
        final List<Line> linesValue = List.of(line, line2);
        final Lines lines = new Lines(linesValue);

        final Names names = ParticipantsFixture.createParticipants(2).getNames();
        final GameResults gameResults = GameResultsFixture.createGameResults(2);
        final String ladderForm = LadderForm.joinUnitsFrom(names, lines, gameResults);
        System.out.println( ladderForm);
        assertThat(ladderForm).contains(" name0 name1\n     |-----|\n     |-----|\n name0 name1");
    }
}