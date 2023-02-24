package laddergame.domain.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    private static final int MOVING_UNIT = 1;
    private String participantName;

    @BeforeEach
    void setUp() {
        participantName = "poby";
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("오른쪽으로 움직이면 참여자의 위치 1 증가한다.")
    void increases_by_1_if_participant_moves_to_the_right(final int basePosition) {
        Participant participant = Participant.create(participantName, basePosition);

        participant.moveToTheRight();

        assertThat(participant.getParticipantPosition()).isEqualTo(basePosition + MOVING_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("왼쪽으로 움직이면 참여자의 위치 1 감소한다.")
    void decreases_by_1_if_participant_moves_to_the_left(final int basePosition) {
        Participant participant = Participant.create(participantName, basePosition);

        participant.moveToTheLeft();

        assertThat(participant.getParticipantPosition()).isEqualTo(basePosition - MOVING_UNIT);
    }
}
