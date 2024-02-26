package ladder.domain.ladder;

import ladder.exception.participant.NoSuchParticipantException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantsOutcomeTest {
    @Test
    @DisplayName("존재하지 않는 참가자를 입력할 경우 예외가 발생한다.")
    void noSuchParticipantTest() {
        // given
        final ParticipantsOutcome participantsOutcome = new ParticipantsOutcome(Map.of("poo", "100"));

        // when & then
        assertThatThrownBy(() -> participantsOutcome.getOutcome("a"))
                .isInstanceOf(NoSuchParticipantException.class);
    }

    @Test
    @DisplayName("입력이 all일 경우 allOutcomesRequired()가 참을 반환한다.")
    void allOutcomesRequiredTest() {
        // given
        final ParticipantsOutcome participantsOutcome = new ParticipantsOutcome(Map.of("mia", "꽝"));

        // when & then
        assertTrue(participantsOutcome.allOutcomesRequired("all"));
    }

    @Test
    @DisplayName("올바르게 참가자 이름에 해당하는 결과를 반환한다.")
    void getOutcomeTest() {
        // given
        final String participantName = "mia";
        final String expectedOutcome = "꽝";
        final ParticipantsOutcome participantsOutcome = new ParticipantsOutcome(Map.of(participantName, expectedOutcome, "pota", "100"));

        // when
        final String actualOutcome = participantsOutcome.getOutcome(participantName);

        // then
        assertThat(actualOutcome).isEqualTo(expectedOutcome);
    }
}
