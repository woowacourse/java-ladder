package laddergame.domain.reward;

import laddergame.BuilderObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {
    private BuilderObject rewards;
    RewardsBuilder rewardsBuilder;

    @BeforeEach
    void setUp() {
        rewardsBuilder = new RewardsBuilder("꽝,3000,5000,꽝");
        rewards = rewardsBuilder.createElement();
    }

    @Test
    public void 해당_인덱스의_결과값_제대로_가져오는지() {
        assertThat(rewards.getNameOfIndex(1)).isEqualTo("꽝");
    }
}