package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    private Players players;

    @BeforeEach
    void setUp() {
        players = new Players("pobi,denis,gorae");
    }

    @Test
    void 생성() {
        assertThat(players.getPlayers()).contains(new Player("pobi"), new Player("denis"), new Player("gorae"));
    }

    @Test
    void 인덱스() {
        assertThat(players.getPlayer(1)).isEqualTo(new Player("denis"));
    }

    @Test
    void 카운트() {
        assertThat(players.getCount()).isEqualTo(3);
    }
}
