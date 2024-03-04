package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @DisplayName("중복된 참가자들은 존재할 경우 예외가 발생한다.")
    @Test
    void validateNotDuplicateName() {
        assertThatThrownBy(() -> new Participants(
                List.of(new Participant(new Name("pobi")),
                        new Participant(new Name("pobi")))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 참가자들은 존재할 수 없습니다.");
    }

    @DisplayName("참가자의 수가 2명 미만일 경우 예외가 발생한다.")
    @Test
    void moreThanOneParticipants() {
        assertThatThrownBy(() -> new Participants(
                List.of(new Participant(new Name("pobi")))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자가 2명 미만인 경우는 존재할 수 없습니다.");
    }
}
