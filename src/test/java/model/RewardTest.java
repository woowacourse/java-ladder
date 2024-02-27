package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {

    @DisplayName("특정 위치에 어떤 결과가 있는지 알 수 있다.")
    @Test
    void reward() {
        Reward reward = new Reward(List.of("꽝", "5000", "꽝", "3000"));
        assertThat(reward.valueOf(0)).isEqualTo("꽝");
    }
}
