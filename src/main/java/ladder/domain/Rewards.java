package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.domain.Players.MINIMUM_NUMBER_FOR_GAMES;

public class Rewards {
	private final List<Reward> rewards;

	public Rewards(final List<Reward> rewards) {
		this.rewards = new ArrayList<>(rewards);
		validateCountOfRewardNumber(rewards);
	}

	private void validateCountOfRewardNumber(List<Reward> rewards) {
		if (rewards.size() < MINIMUM_NUMBER_FOR_GAMES) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_GAME_RESULTS.getOutputMessage());
		}
	}

	public int getSize() {
		return rewards.size();
	}

	public Reward getReward(int index) {
		if (index < 0 || index >= rewards.size()) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_INDEX.getOutputMessage());
		}
		return rewards.get(index);
	}

	public List<Reward> getRewards() {
		return Collections.unmodifiableList(rewards);
	}
}
