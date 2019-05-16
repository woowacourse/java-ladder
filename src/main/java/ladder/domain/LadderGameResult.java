package ladder.domain;

import java.util.Map;
import java.util.Set;

public class LadderGameResult {
	private final Map<String, String> gameResult;

	public LadderGameResult(Map<String, String> gameResult) {
		this.gameResult = gameResult;
	}

	public String getReward(String playerName) {
		return gameResult.get(playerName);
	}

	public Set<String> getAllPlayerNames() {
		return gameResult.keySet();
	}
}
