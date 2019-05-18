package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {
    private Results results;

    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
        Map<PlayerName, Reward> resultPairs = new HashMap<>();
        resultPairs.put(new PlayerName("pobi"), new Reward("꽝"));
        resultPairs.put(new PlayerName("crong"), new Reward("2000"));
        resultPairs.put(new PlayerName("honux"), new Reward("3000"));
        results = new Results(resultPairs);
    }

    @Test
    void getRewardSuccessTest() {
        assertThat(results.getRewardOf(new PlayerName("pobi"))).isEqualTo(new Reward("꽝"));
    }

    @Test
    void getRewardNoMatchTest() {
        assertThrows(RuntimeException.class, () -> results.getRewardOf(new PlayerName("yumin")));
        assertThat(results.getRewardOf(new PlayerName("pobi"))).isEqualTo(new Reward("꽝"));
    }
}
