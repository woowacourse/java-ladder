package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    @Test
    @DisplayName("Reward 는 결과 이름을 넣어 생성할 수 있다.")
    void rewardTest() {
        Reward reward = new Reward("실행 결과");

        Assertions.assertThat(reward.getRewardName()).isEqualTo("실행 결과");
    }
}
