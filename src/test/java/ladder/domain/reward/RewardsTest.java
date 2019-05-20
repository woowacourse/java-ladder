package ladder.domain.reward;

import ladder.domain.player.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {
    @Test
    void players_생성() {
        String[] inputReward = {"100", "200", "꽝"};
        Rewards rewards = new Rewards(inputReward);
        assertThat(rewards.getRewards()).containsExactly(new Reward("100"), new Reward("200"), new Reward("꽝"));
    }

    @Test
    void players가_없는_경우() {
        String[] rewards = {};
        assertThatThrownBy(() -> new Players(rewards)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void players가_null인_경우() {
        assertThatThrownBy(() -> new Players(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
