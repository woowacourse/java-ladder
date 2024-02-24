package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @DisplayName("이름이 최대 글자를 초과할 경우 예외가 발생한다.")
    @Test
    void occurExceptionIfNameExceedsMaxLength() {
        assertThatThrownBy(() -> new Participant("clover"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
