package laddergame.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexValidatorTest {

    @Test
    @DisplayName("인덱스가 범위를 넘어갈 경우 예외와 의도한 메시지를 던진다.")
    void should_ThrowException_When_IndexOutOfBounds() {
        String exceptionMessage = "예외 메시지";
        assertThatThrownBy(() -> IndexValidator.validateBounds(Integer.MAX_VALUE, 1, exceptionMessage))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(exceptionMessage);
    }
}
