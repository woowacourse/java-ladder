package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantPositionTest {

    private static final int MOVING_UNIT = 1;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("위치를 증가시키면, 위치가 1 오른다.")
    void increases_by_1_if_position_increases(int basePosition) {
        ParticipantPosition participantPosition = new ParticipantPosition(basePosition);
        int expectedPosition = basePosition + MOVING_UNIT;

        ParticipantPosition updatedPosition = participantPosition.increase();
        int actualPosition = updatedPosition.getPosition();

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("위치를 감소시키면, 위치가 1 감소한다.")
    void decreases_by_1_if_position_decreases(int basePosition) {
        ParticipantPosition participantPosition = new ParticipantPosition(basePosition);
        int expectedPosition = basePosition - MOVING_UNIT;

        ParticipantPosition updatedPosition = participantPosition.decrease();
        int actualPosition = updatedPosition.getPosition();

        assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}
