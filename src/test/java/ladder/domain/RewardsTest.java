package ladder.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {
	@Test
	void 게임의_보상_리스트_생성() {
		assertDoesNotThrow(() -> new Rewards(Arrays.asList(new Reward("1000"), new Reward("꽝"))));
	}

	@Test
	void 게임의_보상_리스트_개수_검사() {
		assertThrows(IllegalArgumentException.class, () -> new Rewards(Arrays.asList(new Reward("1000"))));
	}

	@Test
	void 게임의_보상_리스트_인덱스_검사() {
		Rewards rewards = new Rewards(Arrays.asList(new Reward("1000"), new Reward("꽝")));
		assertThrows(IllegalArgumentException.class, () -> rewards.getReward(-1));
		assertThrows(IllegalArgumentException.class, () -> rewards.getReward(2));
		assertDoesNotThrow(() -> rewards.getReward(1));
	}
}