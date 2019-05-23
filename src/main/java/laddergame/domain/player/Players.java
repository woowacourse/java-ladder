package laddergame.domain.player;

import laddergame.domain.AbstractName;
import laddergame.domain.NameList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players implements NameList {
	private final List<Player> players;

	public Players(final List<Player> players) {
		this.players = new ArrayList<>(players);
	}

	@Override
	public String getNameOfIndex(int index) {
		return players.get(index - 1).getName();
	}

	@Override
	public boolean isSizeEqual(NameList other) {
		return (this.players.size() == other.getSize());
	}

	@Override
	public int getSize() {
		return players.size();
	}

	@Override
	public List<? extends AbstractName> getNames() {
		return new ArrayList<>(this.players);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Players)) return false;
		Players that = (Players) o;
		return Objects.equals(players, that.players);
	}

	@Override
	public int hashCode() {
		return Objects.hash(players);
	}
}
