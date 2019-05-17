package ladder;

import java.util.*;

import ladder.domain.Ladder;
import ladder.domain.LadderGameResult;

public class LadderGame {
	private List<String> players;

	public LadderGame(List<String> players) {
		this.players = players;
	}

	public LadderGameResult run(List<String> gameReward, Ladder ladder) {
		Map<String, String> gameResult = new LinkedHashMap<>();

		for(int i=0; i<players.size(); ++i) {
			gameResult.put(players.get(i), gameReward.get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}
}
