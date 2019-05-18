package ladder.domain.Reward;

import ladder.domain.reward.RewardGroup;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RewardGroupTest {
    @Test
    public void 보상개수다른경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RewardGroup(Arrays.asList("a", "b", "c"), 2);
        });
    }
}