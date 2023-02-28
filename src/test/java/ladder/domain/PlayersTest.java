package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("Players에 플레이어 이름이 정확히 들어가야 한다.")
    void containsTest() {
        List<Player> rawPlayers = List.of(
                new Player("pobi", 0),
                new Player("crong", 1),
                new Player("hardy", 2)
        );

        Players players = new Players(rawPlayers);
        assertTrue(players.contains("pobi"));
        assertTrue(players.contains("crong"));
        assertTrue(players.contains("hardy"));

        assertFalse(players.contains("hero"));
    }
}
