package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayersTest {

    @Test
    public void 플레이어_생성_테스트() {
        Players players = new Players("a,b,c,d");
        List<Player> playerList = Arrays.asList(new Player("a", 0), new Player("b", 1), new Player("c", 2), new Player("d", 3));
        assertEquals(playerList, players.list());
    }
}
