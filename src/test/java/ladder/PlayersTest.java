package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.Player;
import ladder.model.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    String[] names;

    @BeforeEach
    void setup() {
        names = new String[]{"bmo", "pobi"};
    }

    @Test
    void Players에_포함된_이름일_때_검증() {
        Players players = new Players(names);
        assertThat(players.isContains("bmo")).isTrue();
    }

    @Test
    void Players에_포함되지_않은_이름일_때_검증() {
        Players players = new Players(names);
        assertThat(players.isContains("crong")).isFalse();
    }

    @Test
    void Players의_모든_플레이어_가져왔을때_제대로_가져오는지_검증() {
        Players players = new Players(names);
        assertThat(players.getAllPlayers()).isEqualTo(Arrays.asList(new Player("bmo", 0), new Player("pobi", 1)));
    }

    @Test
    void Players의_모든_플레이어를_가져왔을때_players가_다른경우_검증() {
        Players players = new Players(names);
        assertThat(players.getAllPlayers()).isNotEqualTo(Arrays.asList(new Player("bmo", 0), new Player("crong", 1)));
    }
}