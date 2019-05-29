package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameInformation {
	private final Players players;
	private final Rewards rewards;

	public LadderGameInformation(List<Player> players, List<Reward> rewards) {
		this.players = new Players(players);
		this.rewards = new Rewards(rewards);
		validateGameInformation(this.players, this.rewards);
	}

	private void validateGameInformation(Players players, Rewards rewards) {
		if (players.getSize() != rewards.getSize()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}

	public Map<Player, Reward> matchPlayersAndRewards(Ladder ladder) {
		Map<Player, Reward> matchResult = new LinkedHashMap<>();

		for (int i = 0; i < players.getSize(); i++) {
			matchResult.put(players.getPlayer(i), rewards.getReward(ladder.getLastPosition(i)));
		}
		return matchResult;
	}

	public int getPlayersSize() {
		return players.getSize();
	}

	public Players getPlayers() {
		return players;
	}

	public Rewards getRewards() {
		return rewards;
	}
}