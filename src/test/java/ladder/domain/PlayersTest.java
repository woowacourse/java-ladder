package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    void players_생성() {
        String[] playerNames = {"pobi", "denis", "whale"};
        Players players = new Players(playerNames);
        assertThat(players.getPlayers()).containsExactly(new Player("pobi"), new Player("denis"), new Player("whale"));
    }

    @Test
    void players가_없는_경우() {
        String[] playerNames = {};
        assertThatThrownBy(() -> new Players(playerNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void players가_null인_경우() {
        assertThatThrownBy(() -> new Players(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
