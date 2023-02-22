package laddergame.domain;

import laddergame.constant.ErrorCode;
import laddergame.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    private Players getDefaultPlayers() {
        return new Players(List.of("test1", "test2", "test3", "test4"));
    }

    @Test
    @DisplayName("이름으로 사용자의 위치를 찾는다.")
    void positionOfTest() {
        String playerName = "test2";
        int expectedPosition = 2;
        Players players = getDefaultPlayers();

        assertThat(players.positionOf(playerName)).isEqualTo(new Position(expectedPosition));
    }

    @Test
    @DisplayName("없는 이름을 검색하면 예외를 발생시킨다.")
    void positionOfExceptionTest() {
        String playerName = "test5";
        Players players = getDefaultPlayers();

        assertThatThrownBy(() -> players.positionOf(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.PLAYER_NAME_NOT_FOUND.getCode());
    }
}
