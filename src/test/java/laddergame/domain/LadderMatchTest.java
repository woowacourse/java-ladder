package laddergame.domain;

import laddergame.fixture.LadderFixture;
import laddergame.fixture.ParticipantsFixture;
import laddergame.fixture.ResultsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 매칭")
class LadderMatchTest {
    @DisplayName("Ladder가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenLadderIsNull() {
        final Ladder ladder = null;
        final Participants participants = ParticipantsFixture.createParticipantsSize3();
        final Results results = ResultsFixture.createResultsSize2();

        assertThatThrownBy(() -> new LadderMatch(ladder, participants, results));
    }

    @DisplayName("Participants가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenParticipantsIsNull() {
        final Ladder ladder = LadderFixture.createLadderWidth3Height3();
        final Participants participants = null;
        final Results results = ResultsFixture.createResultsSize3();

        assertThatThrownBy(() -> new LadderMatch(ladder, participants, results));
    }

    @DisplayName("Results가 null일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenResultsIsNull() {
        final Ladder ladder = LadderFixture.createLadderWidth3Height3();
        final Participants participants = ParticipantsFixture.createParticipantsSize3();
        final Results results = null;

        assertThatThrownBy(() -> new LadderMatch(ladder, participants, results));
    }

    @DisplayName("이름에 대응되는 결과를 가져온다.")
    @Test
    void getResultByName() {
        final Participants participants = new Participants(List.of("hyena", "jayon", "rosie"));
        final Line line1 = new Line(List.of(true, false));
        final Line line2 = new Line(List.of(true, false));
        final Lines lines = new Lines(List.of(line1, line2));
        final Ladder ladder = new Ladder(lines);
        final Results results = new Results(List.of("aaa", "bbb", "ccc"), participants.getNames());

        final LadderMatch ladderMatch = new LadderMatch(ladder, participants, results);
        final Map<Name, Result> matchResult = ladderMatch.getLadderMatchResults("hyena");
        final String findName = matchResult.get(new Name("hyena")).getValue();

        assertThat(findName).isEqualTo("aaa");
    }

    @DisplayName("all을 입력할 경우 모든 매칭 결과를 가져온다.")
    @Test
    void getLadderMatchResults() {
        final Participants participants = new Participants(List.of("hyena", "jayon", "rosie"));
        final Line line1 = new Line(List.of(true, false));
        final Line line2 = new Line(List.of(true, false));
        final Lines lines = new Lines(List.of(line1, line2));
        final Ladder ladder = new Ladder(lines);
        final Results results = new Results(List.of("aaa", "bbb", "ccc"), participants.getNames());

        final LadderMatch ladderMatch = new LadderMatch(ladder, participants, results);
        final Map<Name, Result> ladderMatchResults = ladderMatch.getLadderMatchResults("all");

        assertThat(ladderMatchResults).hasSize(3);
    }
}