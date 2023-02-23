package domain;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatNoException().isThrownBy(
                () -> new LadderGame(createDefaultParticipants(), ladder, createPrizesFrom("1", "2", "3", "4")));
    }

    @ParameterizedTest
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
        LadderGame ladder = new LadderGame(participants, lines, prizes);

        assertThat(ladder.findPrizeFor(participantName)).isEqualTo(expectedPrize);
    }
}
