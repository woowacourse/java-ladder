package laddergame.domain.ladder;

import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladderWithSameStartAndEndPosition;
    private Participants participants;

    @BeforeEach
    void setUp() {
        ladderWithSameStartAndEndPosition = Ladder.create(() -> true, "2", 4);
        participants = Participants.create("1st,2nd,3rd,4th");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("참여자를 입력하면, 도착지로 이동시키는지 확인한다.")
    void moves_participant_test(int startPosition) {
        Participant participant = participants.getParticipants().get(startPosition);

        ladderWithSameStartAndEndPosition.moveToDestination(participant);
        int endPosition = participant.getParticipantPosition();

        assertThat(endPosition).isEqualTo(startPosition);
    }
}
