package domain;

import exception.Error;

public class Result {
	private final String reward;

	public Result(String reward) {
		validate(reward);
		this.reward = reward;
	}

	public String getSequence() {
		return this.reward;
	}

	private void validate(String reward) {
		reward = reward.trim();
		if (reward.length() < 1 || reward.length() > 5) {
			throw new IllegalArgumentException(Error.INVALID_SEQUENCE_LENGTH.getMessage());
		}
	}
}
