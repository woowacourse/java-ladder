package ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayersTest {

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_필터_예외_테스트() {
        Players players = new Players(Arrays.asList("a", "b", "c", "d"));
        players.player("z");
    }

    @Test
    public void 플레이어_필터_정상_테스트() {
        Players players = new Players(Arrays.asList("a", "b", "c", "d"));
        assertEquals(new Player("a", 0), players.player("a"));
    }

    @Test
    public void 플레이어_생성_테스트() {
        Players players = new Players(Arrays.asList("a", "b", "c", "d"));
        List<Player> playerList = Arrays.asList(new Player("a", 0), new Player("b", 1), new Player("c", 2), new Player("d", 3));
        assertEquals(playerList, players.list());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_생성_예외() {
        Players players = new Players(Arrays.asList("    "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_생성_예외2() {
        Players players = new Players(Arrays.asList("a", "a", "b"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_생성_예외3() {
        Players players = new Players(Arrays.asList("a", " ", "b"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_생성_예외4() {
        Players players = new Players(Arrays.asList("a", "b", "abcdefg"));
    }

}
