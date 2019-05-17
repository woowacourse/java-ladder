package laddergame.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    private Rewards rewards;
    RewardsBuilder rewardsBuilder;

    @BeforeEach
    void setUp() {
        rewardsBuilder = new RewardsBuilder("꽝,3000,5000,꽝");
        rewards = rewardsBuilder.buildDestinations();
    }

    @Test
    public void 객체_생성() {
        assertThat(rewards).isEqualTo(rewardsBuilder.buildDestinations());
    }

    @Test
    public void 해당_인덱스의_결과값_제대로_가져오는지() {
        assertThat(rewards.getDestination(1).toString()).isEqualTo("꽝");
    }
}