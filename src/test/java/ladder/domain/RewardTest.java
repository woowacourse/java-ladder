package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardTest {
	@Test
	void 정상작동() {
		assertDoesNotThrow(() -> new Reward("꽝"));
	}

	@Test
	void 게임의_보상이_빈칸인_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Reward(""));
	}

	@Test
	void 게임의_보상이_공백으로만_이루어진_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new Reward("    "));
	}
}
