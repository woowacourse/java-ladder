package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

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
        assertThatThrownBy(() -> new Players(playerNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Player가 2명 미만일 경우 예외가 발생한다.")
    void playersSizeExceptionTest() {
        List<String> playerNames = List.of("test1");
        assertThatThrownBy(() -> new Players(playerNames)).isInstanceOf(IllegalArgumentException.class);
    }
}