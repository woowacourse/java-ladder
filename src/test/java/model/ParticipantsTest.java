package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("중복된 참가자들은 존재할 경우 예외가 발생한다.")
    void validateNotDuplicateName() {
        assertThatThrownBy(() -> new Participants(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 참가자들은 존재할 수 없습니다.");
    }

}