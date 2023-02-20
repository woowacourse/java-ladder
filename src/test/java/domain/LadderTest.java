package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import helper.AbstractTestFixture;

class LadderTest extends AbstractTestFixture {

    @ParameterizedTest(name = "사다리의 높이는 양수만 가능하다")
    @ValueSource(ints = {1, 999})
    void test_ladder_height_success(int height) {
        assertThatNoException().isThrownBy(() -> new Ladder(createDefaultParticipants(), createLines(height),
                createPrizesFrom("1", "2", "3", "4")));
    }

    @Test
    @DisplayName("사다리의 높이가 양수가 아니면 IllegalArgumentException를 던진다")
    void test_ladder_height_throws() {
        assertThatThrownBy(
                () -> new Ladder(createDefaultParticipants(), createLines(0), createPrizesFrom("1", "2", "3", "4")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line들로 Ladder를 생성한다")
    void test_createLadder_with_lines() {
        List<Line> lines = List.of(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );

        assertThatNoException().isThrownBy(
                () -> new Ladder(createDefaultParticipants(), lines, createPrizesFrom("1", "2", "3", "4")));
    }

    @ParameterizedTest
    @CsvSource({"a,3", "b,4", "c,1", "d,2"})
    void 특정_참가자의_결과를_알_수_있다(String participantName, String expectedPrize) {
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d"));
        List<Line> lines = List.of(
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true)),
                new Line(convert(false, true, false)),
                new Line(convert(true, false, true))
        );
        List<String> prizes = createPrizesFrom("1", "2", "3", "4");
        Ladder ladder = new Ladder(participants, lines, prizes);

        assertThat(ladder.findPrizeFor(participantName)).isEqualTo(expectedPrize);
    }
}
