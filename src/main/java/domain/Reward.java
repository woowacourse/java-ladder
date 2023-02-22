package domain;

public class Reward {

    private static final int REWARD_MIN_SIZE_INCLUSIVE = 1;
    private static final int REWARD_MAX_SIZE_INCLUSIVE = 5;
    private static final String REWARD_SIZE_ERROR_MESSAGE = "상품은 1 ~ 5 글자여야 합니다.";

    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        if (!(REWARD_MIN_SIZE_INCLUSIVE <= reward.length() && reward.length() <= REWARD_MAX_SIZE_INCLUSIVE)) {
            throw new IllegalArgumentException(REWARD_SIZE_ERROR_MESSAGE);
        }
    }

}
