package model.result;

import model.participant.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static model.result.ParticipantsResult.NOT_EXIST_PARTICIPANT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsResultTest {
    @DisplayName("존재하지 않는 참가자의 시작 순서를 알려고 한다면 예외가 발생한다.")
    @Test
    void notExistParticipants() {
        ParticipantsResult participantsResult = new ParticipantsResult(Map.of(new Participant("pobi"), new Result("꽝"), new Participant("left"), new Result("5000")));
        assertThatThrownBy(() -> participantsResult.getResult(new Participant("tobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_EXIST_PARTICIPANT);
    }
}
