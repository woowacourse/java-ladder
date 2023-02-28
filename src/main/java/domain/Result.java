package domain;

public class Result {
	private final String reward;

	public Result(String reward) {
		validate(reward);
		this.reward = reward;
	}

	private void validate(String reward) {
		reward = reward.strip();
		int MIN_LENGTH = 1;
		int MAX_LENGTH = 5;
		if (reward.length() < MIN_LENGTH || reward.length() > MAX_LENGTH) {
			throw new IllegalArgumentException(String.format("예상 결과는 %d ~ %d글자만 가능합니다", MIN_LENGTH, MAX_LENGTH));
		}
	}

	public String getReward() {
		return this.reward;
	}
}
