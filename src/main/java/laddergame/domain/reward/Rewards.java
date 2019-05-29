package laddergame.domain.reward;

import laddergame.domain.AbstractName;
import laddergame.NameList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rewards implements NameList {
	private final List<Reward> rewards;

	public Rewards(final List<Reward> rewards) {
		this.rewards = new ArrayList(rewards);
	}

	@Override
	public String getNameOfIndex(final int index) {
		return rewards.get(index - 1).getName();
	}

	@Override
	public boolean isSizeEqual(final NameList other) {
		return (this.rewards.size() == other.getSize());
	}

	@Override
	public int getSize() {
		return rewards.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rewards)) return false;
		Rewards rewards1 = (Rewards) o;
		return Objects.equals(rewards, rewards1.rewards);
	}

	@Override
	public List<? extends AbstractName> getNames() {
		return new ArrayList<>(rewards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rewards);
	}
}
