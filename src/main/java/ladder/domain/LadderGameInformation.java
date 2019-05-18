package ladder.domain;

import java.util.HashSet;
import java.util.List;

public class LadderGameInformation {
	private final List<Player> players;
	private final List<Reward> rewards;

	public LadderGameInformation(List<Player> players, List<Reward> rewards) {
		validateNamesLength(players);
		validateOverlapPlayers(players);
		validatePlayersNumber(players);
		validateGameInformation(players, rewards);
		this.players = players;
		this.rewards = rewards;
	}

	public void validateNamesLength(List<Player> players) {
		if (players.stream().anyMatch(name -> name.toString().length() > 5)) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	private void validateOverlapPlayers(List<Player> players) {
		if (new HashSet<>(players).size() != players.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_OVERLAP_NAMES.getOutputMessage());
		}
	}

	private void validatePlayersNumber(List<Player> players) {
		if(players.size() < 2) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	private void validateGameInformation(List<Player> players, List<Reward> rewards) {
		if (players.size() != rewards.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Reward> getRewards() {
		return rewards;
	}
}
