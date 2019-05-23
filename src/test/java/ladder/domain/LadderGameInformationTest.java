package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameInformationTest {
	private List<Player> players;
	private List<Reward> rewards;

	@BeforeEach
	void init() {
		this.players = new ArrayList<>(Arrays.asList(new Player("pobi")));
		this.rewards = new ArrayList<>(Arrays.asList(new Reward("꽝")));
	}

	@Test
	void 정상_입력() {
		this.players.add(new Player("jason"));
		this.rewards.add(new Reward("1000"));
		assertDoesNotThrow(() -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 참가자의_수와_게임보상의_수가_다른_경우_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 중복되는_이름의_참가자가_존재할_때_예외_반환() {
		this.players.add(new Player("pobi"));
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}

	@Test
	void 참가자의_수가_2명_미만일_때_예외_반환() {
		assertThrows(IllegalArgumentException.class, () -> new LadderGameInformation(players, rewards));
	}
}