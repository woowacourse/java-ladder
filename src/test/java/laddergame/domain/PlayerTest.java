package laddergame.domain;

import laddergame.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("\"test\"라는 이름으로 Player가 정상적으로 생성된다.")
    void playerCreateTest() {
        String playerName = "test";
        assertDoesNotThrow(() -> new Player(playerName));
    }

    @ParameterizedTest(name = "{0} 라는 이름으로 Player를 생성할 경우 예외가 발생한다.")
    @ValueSource(strings = {"  ", "test11"})
    void playerCreateExceptionTest(String playerName) {
        assertThatThrownBy(() -> new Player(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_VALID_PLAYER_NAME.getMessage());
    }
}