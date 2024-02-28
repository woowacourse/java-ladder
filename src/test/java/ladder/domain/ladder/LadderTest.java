package ladder.domain.ladder;

import ladder.domain.Position;
import ladder.domain.participant.Participants;
import ladder.testutil.LadderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("참가자가 도착한 사다리 마지막 위치를 반환한다.")
    void determineFinalPositionOfParticipantTest() {
        // given
        final Participants participants = new Participants(List.of("a", "b", "c"));
        final Ladder ladder = generateLadder();
        final List<Position> expectedPositions = List.of(new Position(2), new Position(0), new Position(1));

        // when
        final List<Position> actualPositions = participants.getValues().stream()
                .map(ladder::determineFinalPositionOf)
                .toList();

        // then
        assertThat(actualPositions).containsExactlyElementsOf(expectedPositions);
    }

    private static Ladder generateLadder() {
        final List<Boolean> pathAvailabilities = List.of(true, false, false, true);
        return LadderGenerator.generate(pathAvailabilities, 2, 2);
    }
}
