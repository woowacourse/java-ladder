package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("\"test\"라는 이름으로 Player가 정상적으로 생성된다.")
    void playerCreateTest() {
        String playerName = "test";
        assertDoesNotThrow(() -> new Player(playerName));
    }
}