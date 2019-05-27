package ladder;

import java.util.*;

import ladder.domain.*;

public class LadderGame {
	private static final int MINIMUM_NUMBER_FOR_GAMES = 2;
	private final List<Player> players;
	private final List<Reward> rewards;

	public LadderGame(List<Player> players, List<Reward> rewards) {
		validateOverlapPlayerNames(players);
		validateCountOfPlayerNumber(players);
		validateGameInformation(players, rewards);
		this.players = new ArrayList<>(players);
		this.rewards = new ArrayList<>(rewards);
	}

	public LadderGameResult run(Ladder ladder) {
		Map<Player, Reward> gameResult = new LinkedHashMap<>();

		for (int i = 0; i < players.size(); ++i) {
			gameResult.put(players.get(i), rewards.get(ladder.getLastPosition(i)));
		}

		return new LadderGameResult(gameResult);
	}

	private void validateOverlapPlayerNames(List<Player> players) {
		if (new HashSet<>(players).size() != players.size()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_OVERLAP_NAMES.getOutputMessage());
		}
	}

	private void validateCountOfPlayerNumber(List<Player> players) {
		if (players.size() < MINIMUM_NUMBER_FOR_GAMES) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	private void validateGameInformation(List<Player> players, List<Reward> rewards) {
		if (players.size() != rewards.size()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}
}
