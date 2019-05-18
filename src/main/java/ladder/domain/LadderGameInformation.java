package ladder.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderGameInformation {
	private final List<String> players;
	private final List<String> rewards;

	public LadderGameInformation(List<String> players, List<String> rewards) {
		validatePlayerNameAll(players);
		validateNamesLength(players);
		validateOverlapPlayers(new HashSet(players));
		validatePlayersNumber(players);
		validateGameInformation(players, rewards);
		this.players = players;
		this.rewards = rewards;
	}

	public void validateNamesLength(List<String> names) {
		if (!names.stream().allMatch(name -> name.length() <= 5)) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
		}
	}

	public void validatePlayerNameAll(List<String> names) {
		if(names.stream().anyMatch(name -> name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage()))) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAME_ALL.getOutputMessage());
		}
	}

	private void validateOverlapPlayers(Set players) {
		if (players.size() != this.players.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_OVERLAP_NAMES.getOutputMessage());
		}
	}

	private void validatePlayersNumber(List<String> players) {
		if(players.size() < 2) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	private void validateGameInformation(List<String> players, List<String> rewards) {
		if (players.size() != rewards.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}

	public List<String> getPlayers() {
		return players;
	}

	public List<String> getRewards() {
		return rewards;
	}
}
