package ladder;

import java.util.*;

import ladder.domain.*;

public class LadderGame {
	public static LadderGameResult run(LadderGameInformation ladderGameInformation, Ladder ladder) {
		Map<Player, Reward> gameResult = new LinkedHashMap<>();
		List<Player> players = ladderGameInformation.getPlayers();

		for (int i = 0; i < players.size(); ++i) {
			gameResult.put(players.get(i), ladderGameInformation.getRewards().get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}
}
