package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RewardsTest {

    @Test
    @DisplayName("플레이어 숫자와 다른 갯수로 보상이 들어오면 예외 발생")
    void createRewardsExceptionTest() {
        int playerCount = 5;
        List<String> inputRewards = List.of("꽝", "3000", "꽝", "5000");
        assertThatThrownBy(() -> Rewards.create(inputRewards, playerCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 생성 테스트")
    void createRewardsTest() {
        int playerCount = 4;
        List<String> inputRewards = List.of("꽝", "3000", "꽝", "5000");
        assertDoesNotThrow(() -> Rewards.create(inputRewards, playerCount));
    }

    @Test
    @DisplayName("n번째 위치에 있는 보상 찾는 기능")
    void findRewardByIndexTest() {
        int playerCount = 4;
        List<String> inputRewards = List.of("꽝", "3000", "꽝", "5000");
        Rewards rewards = Rewards.create(inputRewards, playerCount);
        assertThat(rewards.findRewardByIndex(0).getReward()).isEqualTo("꽝");
        assertThat(rewards.findRewardByIndex(1).getReward()).isEqualTo("3000");
        assertThat(rewards.findRewardByIndex(2).getReward()).isEqualTo("꽝");
        assertThat(rewards.findRewardByIndex(3).getReward()).isEqualTo("5000");
    }

}
