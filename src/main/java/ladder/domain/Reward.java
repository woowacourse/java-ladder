package ladder.domain;

class Reward {
    private static final String BLANK = "";
    private static final int MAX_REWARD_LENGTH = 5;

    private final String result;

    Reward(String result) {
        validReward(result);
        this.result = result;
    }

    private void validReward(String reward) {
        checkBlank(reward);
        if (reward.length() > MAX_REWARD_LENGTH) {
            throw new IllegalArgumentException(String.format("%s 의 길이가 너무 깁니다.", reward));
        }
    }

    private void checkBlank(String result) {
        if (result.equals(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    String getResult() {
        return result;
    }
}
