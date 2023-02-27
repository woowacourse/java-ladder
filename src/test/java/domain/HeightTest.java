package domain;

import exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    @DisplayName("양수가 아닌 값이 들어오면 에러를 발생시킨다.")
    void throwExceptionWhenInputNegativeNumber() {
        int height = -1;

        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
    }
}
