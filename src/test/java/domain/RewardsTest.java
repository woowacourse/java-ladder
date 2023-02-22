package domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("실행 결과는 ")
class RewardsTest {

    private final List<String> rewards = List.of("꽝", "5000", "3000", "꽝");

    @DisplayName("전체 수가 참여자의 수와 같아야 한다.")
    @Test
    void rewardSizeTest_success() {
        assertDoesNotThrow(
            () -> Rewards.of(rewards, rewards.size()));
    }

    @DisplayName("전체 수가 참여자의 수와 다르면 예외가 발생한다.")
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

    @DisplayName("인덱스를 통해 조회할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:5000", "2:3000", "3:꽝"}, delimiter = ':')
    void getRewardsTest_success(int index, String expected) {
        Rewards allRewards = Rewards.of(rewards, rewards.size());

        assertEquals(expected, allRewards.getReward(index));
    }

    @DisplayName("사이즈 이상의 값이나 0 미만의 인덱스로 조회하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5})
    void getRewardsTest_fail(int index) {
        Rewards allRewards = Rewards.of(rewards, rewards.size());
        assertThrows(IllegalArgumentException.class,
            () -> allRewards.getReward(index));
    }

}