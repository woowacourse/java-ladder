package ladder;

import java.util.*;

import ladder.domain.*;

public class LadderGame {
	public LadderGameResult run(LadderGameInformation ladderGameInformation, Ladder ladder) {
		Map<Player, Reward> gameResult = new LinkedHashMap<>();
		Players players = ladderGameInformation.getPlayers();
		for (int i = 0; i < players.getSize(); ++i) {
			gameResult.put(players.getPlayers().get(i), ladderGameInformation.getRewards().getRewards().get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}
}