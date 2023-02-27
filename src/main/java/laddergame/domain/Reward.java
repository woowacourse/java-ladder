package laddergame.domain;

public class Reward {
    private static final String FAIL_MESSAGE = "꽝";
    private static final String WRONG_REWARD_NAME_ERROR_MESSAGE = "플레이어의 이름은 중복이 불가능합니다.";

    private final String rewardName;

    public Reward(String rewardName) {
        checkNotFailMessageOrNotDigit(rewardName);
        this.rewardName = rewardName;
    }

    public String getRewardName() {
        return rewardName;
    }

    private void checkNotFailMessageOrNotDigit(String rewardName) {
        if ((!rewardName.equals(FAIL_MESSAGE) && !rewardName.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException(WRONG_REWARD_NAME_ERROR_MESSAGE);
        }
    }
}
