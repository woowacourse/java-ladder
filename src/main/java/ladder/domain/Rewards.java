package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rewards {
	private final List<Reward> rewards;

	public Rewards(final List<Reward> rewards) {
		this.rewards = new ArrayList<>(rewards);
	}

	public int getSize() {
		return rewards.size();
	}

	public List<Reward> getRewards() {
		return Collections.unmodifiableList(rewards);
	}
}
