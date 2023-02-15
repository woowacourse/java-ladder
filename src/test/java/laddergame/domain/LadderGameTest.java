package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("입력받은 값들에 따라 사다리 게임이 정상적으로 세팅된다.")
    void setLadderGameTest() {
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        int height = 5;
        assertDoesNotThrow(() -> {
            LadderGame ladderGame = new LadderGame();
            ladderGame.setPlayers(playerNames);
            ladderGame.makeLadder(height);
        });
    }

}