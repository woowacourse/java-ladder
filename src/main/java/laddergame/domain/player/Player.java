package laddergame.domain.player;

import laddergame.domain.AbstractName;

import java.util.Objects;

public class Player extends AbstractName {
	private final String name;

	public Player(final String name) {
		validate(name);
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Player)) return false;
		Player that = (Player) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
