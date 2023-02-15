package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("Players가 정상적으로 생성된다.")
    void playerCreateTest() {
        List<String> playerNames = List.of("test1", "test2", "test3");
        assertDoesNotThrow(() -> new Players(playerNames));
    }

}