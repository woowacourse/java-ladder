package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @DisplayName("이름이 5글자를 초과할 경우 예외 처리")
    @Test
    void validateNameLengthTest() {
        assertThatThrownBy(() -> new Participant("clover"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
