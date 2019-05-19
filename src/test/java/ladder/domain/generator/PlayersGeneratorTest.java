package ladder.domain.generator;

import ladder.domain.Player;
import ladder.domain.Players;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersGeneratorTest {
    @Test
    void 컴마_기준으로_나누기() {
        String input = "pobi, jason, brown";
        List<String> playerNames = Arrays.asList(input.split(PlayersGenerator.DELIMITER));
        List<Player> players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name, 1));
        }
        Players expected = new Players(players);

        Players actual = new PlayersGenerator(input).generate();

        assertThat(actual.equals(expected)).isTrue();
    }
}

