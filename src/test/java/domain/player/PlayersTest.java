package domain.player;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("특정 index에 존재하는 플레이어 객체를 반환한다.")
    void testGetPlayerInSpecificIndex() {
        Players players = new Players(new PlayerNames(List.of("조이썬", "도비")));

        PlayerName expectedPlayerName1 = new PlayerName("도비");
        PlayerName expectedPlayerName2 = new PlayerName("조이썬");

        PlayerName actualPlayerName1 = players.getPlayerNameAtStartingIndex(1);
        PlayerName actualPlayerName2 = players.getPlayerNameAtStartingIndex(0);

        assertAll(() -> {
            assertEquals(expectedPlayerName1, actualPlayerName1);
            assertEquals(expectedPlayerName2, actualPlayerName2);
        });
    }
}
