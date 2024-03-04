package domain.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("이름을 통해 사용자를 생성한다.")
    void createPlayer() {
        PlayerName playerName = new PlayerName("포비");

        Player player = new Player(playerName);
        assertEquals(player.playerName(), playerName);
    }

    @Test
    @DisplayName("같은 이름인지 메세지를 받아 판별한다.")
    void testHasSameName() {
        PlayerName playerName1 = new PlayerName("포비");
        PlayerName playerName2 = new PlayerName("포비");

        Player player1 = new Player(playerName1);

        assertTrue(player1.hasSamePlayerName(playerName2));
    }
}
