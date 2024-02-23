package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PlayersTest {
    @Test
    @DisplayName("이름 목록을 통해 플레이어 목록을 생성한다.")
    void createPlayers() {
        Names names = new Names(List.of("조이썬", "도비"));

        Players players = new Players(names);

        assertInstanceOf(Players.class, players);
        assertIterableEquals(players.getPlayerNames(), names.getValue());
    }
}
