package ladder.domain.participant;

import ladder.domain.Position;
import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderStep;
import ladder.domain.outcome.Outcomes;
import ladder.exception.participant.InvalidParticipantsCountException;
import ladder.testutil.TestLadderStepsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자들에게 필요한 사다리 너비를 계산한다.")
    void getParticipantsCountTest() {
        // given
        final List<String> names = List.of("mia", "pota", "dora");
        final Participants participants = new Participants(names);

        // when
        final int count = participants.getNecessaryLadderWidth();

        // then
        assertEquals(2, count);
    }

    @ParameterizedTest
    @MethodSource("getInvalidParticipantsNames")
    @DisplayName("참가자 수가 1명 이하일 경우 예외가 발생한다.")
    void checkParticipantsCountTest(final List<String> names) {
        // given & when
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(InvalidParticipantsCountException.class);
    }

    @Test
    @DisplayName("이름 순서에 맞춰 참가자에게 Position을 부여한다.")
    void assignPositionTest() {
        // given
        final List<String> names = List.of("poo", "po", "p");
        final List<Position> expectedPositions = IntStream.range(0, 3)
                .mapToObj(Position::new)
                .toList();

        // when
        final List<Participant>  participants = new Participants(names).getValues();

        // then
        assertThat(participants)
                .extracting(Participant::getStartPosition)
                .containsExactlyElementsOf(expectedPositions);
    }

    @Test
    @DisplayName("사다리와 실행 결과를 입력받아 참가자와 결과를 매핑한다.")
    void assignOutcomesByLadderTest() {
        // given
        final Participants participants = new Participants(List.of("mia", "aim", "poo"));
        final Ladder ladder = generateLadder();
        final Outcomes outcomes = generateOutcomes();
        final Map<String, String> expectedParticipantsOutcome = Map.of("mia", "200", "aim", "100", "poo", "300");

        // when
        final Map<String, String> actualParticipantsOutcome = participants.assignOutcomesByLadder(ladder, outcomes).getValues();

        // then
        assertThat(actualParticipantsOutcome).containsAllEntriesOf(expectedParticipantsOutcome);
    }

    private static Ladder generateLadder() {
        final List<LadderStep> ladderSteps = List.of(
                new LadderStep(List.of(EMPTY, EXIST)),
                new LadderStep(List.of(EMPTY, EXIST)),
                new LadderStep(List.of(EXIST, EMPTY))
        );
        final LadderStepsGenerator ladderStepsGenerator = new TestLadderStepsGenerator(ladderSteps);
        return new Ladder(ladderStepsGenerator);
    }

    private static Outcomes generateOutcomes() {
        return new Outcomes(List.of("100", "200", "300"), 3);
    }

    private static Stream<List<String>> getInvalidParticipantsNames() {
        return Stream.of(List.of("mia"), List.of());
    }
}
