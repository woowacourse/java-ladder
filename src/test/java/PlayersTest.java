import domain.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void players() {
        List<String> rawPlayers = List.of("bito", "kirby");
        Players players = new Players(rawPlayers);
        assertThat(players).isEqualTo(new Players(rawPlayers));
    }
}
