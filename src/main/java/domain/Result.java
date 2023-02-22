package domain;

import exception.Error;

public class Result {
	public static final int MIN_LENGTH = 1;
	public static final int MAX_LENGTH = 5;
	private final String reward;

	public Result(String reward) {
		validate(reward);
		this.reward = reward;
	}

	private void validate(String reward) {
		reward = reward.trim();
		if (reward.length() < MIN_LENGTH || reward.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(Error.INVALID_SEQUENCE_LENGTH.getMessage());
		}
	}

	public String getSequence() {
		return this.reward;
	}
}
