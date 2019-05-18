package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LadderGameInformation {
	private final List<String> players;
	private final List<String> rewards;

	public LadderGameInformation(List<String> players, List<String> rewards) {
		validateGameInformation(players, rewards);
		validateOverlapPlayers(players);
		this.players = players;
		this.rewards = rewards;
	}

	private void validateGameInformation(List<String> players, List<String> rewards) {
		if (players.size() != rewards.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}

	private void validateOverlapPlayers(List<String> players) {
		if(new HashSet<>(players).size() != players.size()) {
			throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_OVERLAP_NAMES.getOutputMessage());
		}
	}

	public List<String> getPlayers() {
		return players;
	}

	public List<String> getRewards() {
		return rewards;
	}
}
