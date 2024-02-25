package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    @DisplayName("이름 목록을 통해 플레이어 목록을 생성한다.")
    void createPlayers() {
        Names names = new Names(List.of("조이썬", "도비"));

        Players players = new Players(names);

        assertInstanceOf(Players.class, players);
        assertIterableEquals(players.getPlayerNames(), names.getValue());
    }

    @Test
    @DisplayName("입력된 이름을 통해 존재하는 플레이어 객체를 검색하여 반환한다.")
    void searchExistPlayer() {
        Names names = new Names(List.of("조이썬", "도비"));
        Name targetName = new Name("도비");

        Players players = new Players(names);
        Player searchedPlayer = players.searchPlayer(targetName);

        Player targetPlayer = new Player(targetName);

        assertNotNull(searchedPlayer);
        assertEquals(targetPlayer, searchedPlayer);
    }

    @Test
    @DisplayName("입력된 이름을 통해 존재하지 않는 플레이어 객체를 검색하여 null를 반환한다.")
    void searchNotExistPlayer() {
        Names names = new Names(List.of("조이썬", "도비"));
        Name targetName = new Name("오리");

        Players players = new Players(names);
        Player searchedPlayer = players.searchPlayer(targetName);

        assertNull(searchedPlayer);
    }
}
