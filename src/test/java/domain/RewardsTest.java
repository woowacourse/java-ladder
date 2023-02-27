package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RewardsTest {

    Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = new Rewards();
    }

    @Test
    void getRewardByIndex() {
        Reward first = new Reward("1");
        Reward second = new Reward("2");
        Reward third = new Reward("3");
        Reward fourth = new Reward("4");
        rewards.add(first);
        rewards.add(second);
        rewards.add(third);
        rewards.add(fourth);

        List<Reward> result = rewards.getRewardByIndex(List.of(1, 3));

        assertThat(result).containsExactly(second, fourth);
    }
}
