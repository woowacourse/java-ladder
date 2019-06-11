package ladder.domain;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class Reward {
	private String reward;

	public Reward(String reward) {
		validateRewardEmpty(reward);
		this.reward = reward;
	}

	private void validateRewardEmpty(String reward) {
		if (StringUtils.isBlank(reward)) {
			throw new IllegalArgumentException(ExceptionOutput.VIOLATE_GAME_REWARD.getOutputMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Reward)) {
			return false;
		}
		Reward reward1 = (Reward) o;
		return reward.equals(reward1.reward);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reward);
	}

	@Override
	public String toString() {
		return this.reward;
	}
}
