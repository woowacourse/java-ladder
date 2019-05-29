package ladder.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {
	@Test
	void create() {
		assertDoesNotThrow(() -> new Rewards(Arrays.asList(new Reward("1000"), new Reward("꽝"))));
	}

	@Test
	void invalidNumberOfRewards() {
		assertThrows(IllegalArgumentException.class, () -> new Rewards(Arrays.asList(new Reward("1000"))));
	}

	@Test
	void invalidIndex() {
		Rewards rewards = new Rewards(Arrays.asList(new Reward("1000"), new Reward("꽝")));
		assertThrows(IllegalArgumentException.class, () -> rewards.getReward(-1));
		assertThrows(IllegalArgumentException.class, () -> rewards.getReward(2));
		assertDoesNotThrow(() -> rewards.getReward(1));
	}
}