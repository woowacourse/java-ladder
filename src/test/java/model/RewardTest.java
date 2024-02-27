package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RewardTest {

    @DisplayName("위치에 따라 결과를 알 수 있다.")
    @Test
    void reward() {
        Reward reward = new Reward(List.of("꽝", "5000", "꽝", "3000"));
        assertAll(
                () -> assertThat(reward.valueOf(0)).isEqualTo("꽝"),
                () -> assertThat(reward.valueOf(1)).isEqualTo("5000"),
                () -> assertThat(reward.valueOf(2)).isEqualTo("꽝"),
                () -> assertThat(reward.valueOf(3)).isEqualTo("3000")
        );
    }
}
