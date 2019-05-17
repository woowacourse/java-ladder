package ladder.domain;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameResultTest {
	private LadderGameResult ladderGameResult;
	private List<String> players;
	private List<String> reward;

	@BeforeEach
	void init() {
		Map<String, String> result = new LinkedHashMap<>();
		players = Arrays.asList("pobi", "tobi", "tiber");
		reward = Arrays.asList("꽝", "당첨", "1000");

		for (int i = 0; i < players.size() ; i++) {
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
		Set<String> rewards = ladderGameResult.getAllPlayerNames();
		rewards.removeAll(players);
		assertEquals(rewards.size(), 0);
	}
}