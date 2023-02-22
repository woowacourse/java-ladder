package domain;


import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("입력된 실행 결과의 수는 ")
class RewardsTest {

    private final List<String> rewards = List.of("꽝", "5000", "3000", "꽝");

    @DisplayName("참여자의 수와 같아야 한다.")
    @Test
    void rewardSizeTest_success() {
        assertDoesNotThrow(
            () -> Rewards.of(rewards, rewards.size()));
    }

    @DisplayName("참여자의 수와 다르면 예외가 발생한다.")
    @Test
    void rewardSizeTest_fail() {
        assertThrows(
            IllegalArgumentException.class,
            () -> Rewards.of(rewards, rewards.size() + 1));
    }

    @DisplayName("공백이 포함되어 입력되면 공백을 제거하여 저장한다.")
    @Test
    void rewardStripTest() {
        List<String> input = List.of("꽝 ", "3000 ");
        Rewards allRewards = Rewards.of(input, input.size());

        assertEquals("꽝", allRewards.getReward(0));
    }

}