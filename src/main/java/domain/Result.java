package domain;

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
			throw new IllegalArgumentException("보상은 1 ~ 5글자만 가능합니다");
		}
	}
}
