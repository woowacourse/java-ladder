package laddergame.domain.reward;

import laddergame.domain.AbstractName;

import java.util.Objects;

public class Reward extends AbstractName {
	private final String reward;

	public Reward(final String name) {
		validate(name);
		this.reward = name;
	}

	@Override
	public String getName() {
		return this.reward;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Reward)) return false;
		Reward reward1 = (Reward) o;
		return Objects.equals(reward, reward1.reward);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reward);
	}
}
