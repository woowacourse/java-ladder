package ladder.domain.generator;

import ladder.domain.Player;
import ladder.domain.generator.PlayerGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerGeneratorTest {
    @Test
    void 컴마_기준으로_나누기() {
        String input = "pobi, jason, brown";
        List<String> playerNames = Arrays.asList(input.split(","));
        List<Player> expected = new ArrayList<>();
        for (String name : playerNames) {
            expected.add(new Player(name));
        }

        List<Player> actual = new PlayerGenerator(input).generate();

        assertThat(actual.equals(expected)).isTrue();
    }
}

