package laddergame.domain;

import laddergame.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    @DisplayName("\"test\"라는 이름으로 Prize 정상적으로 생성된다.")
    void playerCreateTest() {
        String prizeValue = "test";
        assertDoesNotThrow(() -> new Prize(prizeValue));
    }

    @ParameterizedTest(name = "[{index}] 공백입력시 예외를 발생시킨다.")
    @ValueSource(strings = {"", "  "})
    void playerCreateExceptionTest(String prizeValue) {
        assertThatThrownBy(() -> new Prize(prizeValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.EMPTY_INPUT.getCode());
    }

}
