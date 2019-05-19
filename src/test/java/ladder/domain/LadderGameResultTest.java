package ladder.domain;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameResultTest {
	private LadderGameResult ladderGameResult;
	private List<Player> players;
	private List<Reward> reward;

	@BeforeEach
	void init() {
		Map<Player, Reward> result = new LinkedHashMap<>();
		players = Arrays.asList(new Player("pobi"), new Player("tobi"), new Player("tiber"));
		reward = Arrays.asList(new Reward("꽝"), new Reward("당첨"), new Reward("1000"));

		for (int i = 0; i < players.size(); i++) {
			result.put(players.get(i), reward.get(i));
		}

		ladderGameResult = new LadderGameResult(result);
	}

	@Test
	void 참가자에_따라_보상_반환하기() {
		for (int i = 0; i < players.size(); i++) {
			assertEquals(ladderGameResult.getReward(players.get(i)), reward.get(i));
		}
	}

	@Test
	void 모든_참가자의_이름_반환하기() {
		Set<Player> rewards = ladderGameResult.getAllPlayerNames();
		rewards.removeAll(players);
		assertEquals(rewards.size(), 0);
	}
}