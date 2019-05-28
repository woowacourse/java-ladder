package ladder.domain;

import java.util.List;

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

	public Players getPlayers() {
		return this.players;
	}

	public Rewards getRewards() {
		return this.rewards;
	}
}