package domain.info;

public class Reward {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String reward;

    public Reward(final String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(final String reward) {
        validateBlank(reward);
        validateLength(reward);
    }

    private static void validateLength(final String reward) {
        if (reward.length() < MIN_LENGTH || reward.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 글자 이상 %d 글자 이하의 보상만 입력해주세요.", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }

    private static void validateBlank(final String reward) {
        if (reward.isBlank()) {
            throw new IllegalArgumentException(
                    "[ERROR] 빈 문자열(공백)은 보상이 될 수 없습니다."
            );
        }
    }

    public String getReward() {
        return reward;
    }
}
