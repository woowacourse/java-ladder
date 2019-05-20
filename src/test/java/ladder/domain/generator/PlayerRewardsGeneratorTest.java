package ladder.domain.generator;

import ladder.domain.PlayerRewards;
import ladder.domain.Reward;
import ladder.domain.generator.PlayerRewardsGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerRewardsGeneratorTest {
    @Test
    void 컴마_기준으로_나누기() {
        String input = "꽝, 5000, 꽝";
        Map<Integer, Reward> inputMap = new HashMap<>();
        inputMap.put(0, new Reward("꽝"));
        inputMap.put(1, new Reward("5000"));
        inputMap.put(2, new Reward("꽝"));
        PlayerRewards expectedPlayerRewards = new PlayerRewards(inputMap);

        PlayerRewards actualPlayerRewards = new PlayerRewardsGenerator(input).generate();

        assertThat(actualPlayerRewards.equals(expectedPlayerRewards)).isTrue();
    }
}
