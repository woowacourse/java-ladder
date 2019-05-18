package ladder;

import java.util.*;

import ladder.domain.Ladder;
import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;

public class LadderGame {
	public static LadderGameResult run(LadderGameInformation ladderGameInformation, Ladder ladder) {
		Map<String, String> gameResult = new LinkedHashMap<>();
		List<String> players = ladderGameInformation.getPlayers();

		for (int i = 0; i < players.size(); ++i) {
			gameResult.put(players.get(i), ladderGameInformation.getRewards().get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}
}
