package ladder.domain.Reward;

import ladder.domain.reward.Reward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardTest {
    @Test
    public void 이름5글자제한() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reward("abcdef");
        });
    }
}