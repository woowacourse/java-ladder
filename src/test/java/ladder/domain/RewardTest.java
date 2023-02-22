package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RewardTest {
    @Test
    @DisplayName("Reward는 상품으로 구성된 객체이다.")
    void Test() {
        assertDoesNotThrow(() -> {
            new Reward(List.of("꽝", "1000", "2000", "꽝"));
        });
    }

    @Test
    @DisplayName("Reward에서 n번쨰 아이템을 얻을 수 있다.")
    void getPositionOfItemTest() {
        final Reward reward = new Reward(List.of("꽝", "1000", "하이", "2000"));
        assertThat(reward.getRewardOf(2)).isEqualTo("하이");
    }
}
