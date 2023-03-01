package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import helper.AbstractTestFixture;

class LadderGameTest extends AbstractTestFixture {

    @Test
    @DisplayName("Line들로 Ladder를 생성한다")
    void test_createLadder_with_lines() {
        final var ladder = createLadderWith(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)));
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d"));
        final var prizes = createPrizesFrom("1", "2", "3", "4");

        assertThatNoException().isThrownBy(
                () -> new LadderGame(participants, ladder, prizes));
    }

    @ParameterizedTest(name = "특정 참가자의 결과를 알 수 있다")
    @CsvSource({"a,3", "b,4", "c,1", "d,2"})
    void 특정_참가자의_결과를_알_수_있다(String participantName, String expectedPrize) {
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d"));
        final var lines = createLadderWith(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)));
        final var prizes = createPrizesFrom("1", "2", "3", "4");
        LadderGame ladderGame = new LadderGame(participants, lines, prizes);

        assertThat(ladderGame.findPrizeFor(participantName)).isEqualTo(expectedPrize);
    }

    @Test
    @DisplayName("Line들로 Ladder를 생성한다")
    void 참가자_수_경품_수가_같아야한다() {
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d"));
        final var lines = createLadderWith(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)));
        final var prizes = createPrizesFrom("1", "2", "3");

        assertThatIllegalArgumentException().isThrownBy(() -> new LadderGame(participants, lines, prizes));
    }
}
