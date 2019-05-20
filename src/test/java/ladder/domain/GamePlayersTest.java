package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GamePlayersTest {
    @Test
    void 사이즈0_체크() {
        List<Player> players = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            GamePlayers gamePlayers = new GamePlayers(players);
        });
    }

    @Test
    void 이름_중복_체크() {
        List<Player> players = Arrays.asList(new Player("뚱이"), new Player("뚱이"));
        assertThrows(IllegalArgumentException.class, ()->{
            GamePlayers gamePlayers = new GamePlayers(players);
        });
    }
}
