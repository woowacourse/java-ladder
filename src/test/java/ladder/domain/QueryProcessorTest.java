/*

package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueryProcessorTest {
    private QueryProcessor queryProcessor;

    @BeforeEach
    void setup() {
        Players playersAfterGame = new Players(Arrays.asList(new Player(new PlayerName("pobi"), new Position(1)),
                new Player(new PlayerName("crong"), new Position(0)),
                new Player(new PlayerName("honux"), new Position(2))));
        Rewards rewards = new Rewards(Arrays.asList(new Reward("3000"), new Reward("꽝"),
                new Reward("2000")));
        queryProcessor = new QueryProcessor(playersAfterGame, rewards);
    }

    @Test
    void rewardQuerySuccessTest() {
        assertThat(queryProcessor.getRewardOf("pobi")).isEqualTo(new Reward("꽝"));
    }

    @Test
    void rewardQueryNoMatchTest() {
        assertThrows(RuntimeException.class, () -> queryProcessor.getRewardOf("yumin"));
    }
}

*/