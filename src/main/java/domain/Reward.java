package domain;

public class Reward {
    public static final String BLANK_ERROR_GUIDE_MESSAGE = "[ERROR] 실행 결과는 빈 칸이 올 수 없습니다";
    private static final String REWARDS_LENGTH_ERROR_MESSAGE = "[ERROR] 실행 결과는 5자 이하로 입력해주세요.";
    public static final int MAX_NAME_LENGTH = 5;
    private final String reward;

    public Reward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    private void validateReward(String reward) {
        validateBlank(reward);
        validateLength(reward);
    }

    private void validateBlank(String reward) {
        if (reward.isBlank() || reward.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR_GUIDE_MESSAGE);
        }
    }

    private void validateLength(String reward) {
        if (reward.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(REWARDS_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getRewardName() {
        return reward;
    }
}
