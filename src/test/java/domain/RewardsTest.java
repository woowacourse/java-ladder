package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    @Test
    @DisplayName("상품 목록과 참여자의 수가 맞지 않으면 예외를 반환합니다.")
    void createRewardsFail() {
        PlayerNames playerNames = PlayerNames.from(List.of("pobi", "hell"));

        assertThatThrownBy(() -> Rewards.from(playerNames.getSize(), List.of("fail", "5000", "5000")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상품 개수는 참여자 수와 동일하게 입력해야합니다.");
    }

    @Test
    @DisplayName("상품 목록을 생성합니다.")
    void createRewardsSuccess() {
        PlayerNames playerNames = PlayerNames.from(List.of("pobi", "hell"));
        Rewards rewards = Rewards.from(playerNames.getSize(), List.of("fail", "5000"));

        assertThat(rewards.getRewards()).map(Reward::getName)
                .containsExactly("fail", "5000");
    }

}
