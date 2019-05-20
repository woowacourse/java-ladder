package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    private Players players;

    @BeforeEach
    public void setUp() {
        List<Player> inputs = Arrays.asList(new Player("done"), new Player("brown"));
        players = new Players(inputs);

    }

    @Test
    public void checkParticipant() {
        assertThatThrownBy(() -> players.checkParticipant("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> players.checkParticipant("pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getIndex() {
        assertThat(players.getIndex("done")).isEqualTo(0);
        assertThat(players.getIndex("brown")).isEqualTo(1);
    }

    @Test
    public void getNumberOfPlayers() {
        assertThat(players.getNumberOfPlayers()).isEqualTo(2);
    }
}
