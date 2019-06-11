package ladder.domain;

import java.util.Map;
import java.util.Set;

public class LadderGameResult {
	private final Map<Player, Reward> gameResult;

	public LadderGameResult(Map<Player, Reward> gameResult) {
		this.gameResult = gameResult;
	}

	public Reward getReward(Player playerName) {
		return gameResult.get(playerName);
	}

	public Set<Player> getAllPlayerNames() {
		return gameResult.keySet();
	}
}
