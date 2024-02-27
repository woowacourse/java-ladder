package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardTest {
    @Test
    @DisplayName("문자열을 통해 보상을 생성한다.")
    public void createReward() {
        String value = "꽝";

        Reward reward = new Reward(value);

        assertEquals(reward.getValue(), value);
    }
}
