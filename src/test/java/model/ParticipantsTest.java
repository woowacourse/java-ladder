package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("중복된 참가자들은 존재할 경우 예외가 발생한다.")
    void validateNotDuplicateName() {
        assertThatThrownBy(() -> new Participants(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 참가자들은 존재할 수 없습니다.");
    }

    @Test
    @DisplayName("참가자의 수가 1명 이하일 경우 예외가 발생한다.")
    void moreThanOneParticipants() {
        assertThatThrownBy(() -> new Participants(List.of("pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자가 1명 이하인 경우는 존재할 수 없습니다.");
    }

    @DisplayName("참가자들의 시작 위치를 알 수 있다.")
    @Test
    void participantsPosition(){
        Participants participants = new Participants(List.of("pobi", "left", "right"));
        assertThat(participants.getPosition("pobi")).isEqualTo(0);
    }

}
