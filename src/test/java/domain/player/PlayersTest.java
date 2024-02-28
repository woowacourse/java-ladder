package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    @DisplayName("이름 목록을 통해 플레이어 목록을 생성한다.")
    void createPlayers() {
        PlayerNames playerNames = new PlayerNames(List.of("조이썬", "도비"));

        Players players = new Players(playerNames);

        assertInstanceOf(Players.class, players);
        assertIterableEquals(players.getPlayerNames(), playerNames.getValue());
    }

    @Test
    @DisplayName("입력된 이름을 통해 존재하는 플레이어 객체를 검색하여 반환한다.")
    void searchExistPlayer() {
        PlayerNames playerNames = new PlayerNames(List.of("조이썬", "도비"));
        PlayerName targetPlayerName = new PlayerName("도비");

        Players players = new Players(playerNames);
        Player searchedPlayer = players.searchPlayer(targetPlayerName);

        Player targetPlayer = new Player(targetPlayerName);

        assertNotNull(searchedPlayer);
        assertEquals(targetPlayer, searchedPlayer);
    }

    @Test
    @DisplayName("입력된 이름을 통해 존재하지 않는 플레이어 객체를 검색할 때는 예외를 던진다.")
    void searchNotExistPlayer() {
        PlayerNames playerNames = new PlayerNames(List.of("조이썬", "도비"));
        PlayerName targetPlayerName = new PlayerName("오리");

        Players players = new Players(playerNames);

        assertThrows(IllegalArgumentException.class, () -> players.searchPlayer(targetPlayerName));
    }
}
