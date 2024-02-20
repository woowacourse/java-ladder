package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    @Test
    void validateNameLengthTest() {
        assertThatThrownBy(() -> new Participant("clover"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
