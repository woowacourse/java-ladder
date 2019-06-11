package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Players {
	public static final int MINIMUM_NUMBER_FOR_GAMES = 2;
	private final List<Player> players;

	public Players(final List<Player> players) {
		this.players = new ArrayList<>(players);
		validateOverlapPlayerNames();
		validateCountOfPlayerNumber();
	}

	private void validateOverlapPlayerNames() {
		if (new HashSet<>(this.players).size() != this.players.size()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_PLAYER_OVERLAP_NAMES.getOutputMessage());
		}
	}

	private void validateCountOfPlayerNumber() {
		if (this.players.size() < MINIMUM_NUMBER_FOR_GAMES) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_NUMBER_OF_PLAYERS.getOutputMessage());
		}
	}

	public Player getPlayer(int index) {
		if (index < 0 || index >= players.size()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_INDEX.getOutputMessage());
		}
		return players.get(index);
	}

	public int getSize() {
		return players.size();
	}

	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}
}
