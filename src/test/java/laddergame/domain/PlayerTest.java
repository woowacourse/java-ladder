package laddergame.domain;

import laddergame.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private static final String KOREAN_LANG_CODE = "kor";

    @Test
    @DisplayName("\"test\"라는 이름으로 Player가 정상적으로 생성된다.")
    void playerCreateTest() {
        String playerName = "test";
        assertDoesNotThrow(() -> new Player(playerName));
    }

    @Test
    @DisplayName("공백 입력시 예외를 발생시킨다.")
    void playerNameEmptyExceptionTest() {
        String playerName = " ";
        assertThatThrownBy(() -> new Player(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.EMPTY_INPUT.getCode());
    }

    @Test
    @DisplayName("5자 초과 이름 입력시 예외를 발생한다.")
    void playerNameLengthExceptionTest() {
        String playerName = "123456";
        assertThatThrownBy(() -> new Player(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_VALID_LADDER_LABEL_LENGTH.getCode());
    }
}
