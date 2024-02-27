package domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    @DisplayName("이름 목록을 통해 플레이어 목록을 생성한다.")
    public void createPlayers() {
        Names names = Names.from(List.of("조이썬", "도비"));

        Players players = new Players(names);

        assertIterableEquals(players.getPlayerNames(), names.getValue());
    }

    @Test
    @DisplayName("해당 플레이어가 몇번째인지 인덱스를 받는다.")
    public void getIndexWithPlayer() {
        Names names = Names.from(List.of("조이썬", "도비"));
        Players players = new Players(names);

        Player player = players.getPlayerWithName(new Name("조이썬"));
        int index = players.getPlayerIndex(player);

        assertEquals(0, index);
    }

    @Test
    @DisplayName("이름을 통해 플레이어를 받아온다.")
    public void getPlayerAtName() {
        Name name = new Name("포비");
        Players players = new Players(Names.from(List.of("도비", "조이썬", "포비")));

        Player player = players.getPlayerWithName(name);
        int index = players.getPlayerIndex(player);

        assertEquals(2,index);
    }

    @Test
    @DisplayName("없는 이름을 입력하면 예외를 발생한다.")
    public void throwExceptionWhenNotExistedName() {
        Name name = new Name("매머드");

        Players players = new Players(Names.from(List.of("도비", "조이썬", "포비")));

        assertThrows(IllegalArgumentException.class, () -> players.getPlayerWithName(name));
    }
}
