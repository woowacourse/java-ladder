package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameInformationTest {
	private List<String> players;
	private List<String> rewards;

	@BeforeEach
	void init() {
		this.players = new ArrayList<>(Arrays.asList("pobi", "jason", "woni", "cu", "brown"));
		this.rewards = new ArrayList<>(Arrays.asList("꽝", "1000", "3000", "당첨"));
	}

	@Test
	void 참가자의_수와_게임보상의_수가_다른_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 참가자의_수와_게임보상의_수가_같은_경우() {
		this.rewards.add("꽝");
		assertDoesNotThrow(() -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 중복되는_이름의_참가자가_존재할_때_예외_반환() {
		this.players.add("pobi");
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 참가자의_수가_2명_미만일_때_예외_반환() {
		this.players.removeAll(Arrays.asList("pobi", "jason", "cu", "woni"));
		this.rewards.removeAll(Arrays.asList("꽝", "1000", "3000"));
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 참가자의_수가_2명_이상일_때() {
		this.players.removeAll(Arrays.asList("pobi", "jason", "cu"));
		this.rewards.removeAll(Arrays.asList("3000", "1000"));
		assertDoesNotThrow(() -> new LadderGameInformation(players, rewards));
	}
}