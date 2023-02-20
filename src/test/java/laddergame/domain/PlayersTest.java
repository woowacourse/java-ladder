package laddergame.domain;

import laddergame.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    private static final String KOREAN_LANG_CODE = "kor";

    @Test
    @DisplayName("Players가 정상적으로 생성된다.")
    void playersCreateTest() {
        List<String> playerNames = List.of("test1", "test2", "test3");
        assertDoesNotThrow(() -> new Players(playerNames));
    }

    @Test
    @DisplayName("Player 이름이 중복될 경우 예외가 발생한다.")
    void playersDuplicateExceptionTest() {
        List<String> playerNames = List.of("test1", "test2", "test1");
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.PLAYER_NAME_DUPLICATED.getCode());
    }

    @Test
    @DisplayName("Player가 2명 미만일 경우 예외가 발생한다.")
    void playersSizeExceptionTest() {
        List<String> playerNames = List.of("test1");
        assertThatThrownBy(() -> new Players(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_VALID_PLAYER_COUNT.getCode());
    }
}
