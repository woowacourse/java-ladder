package ladder.domain;

class Reward {
    private static final String BLANK = "";
    private static final int MAX_REWARD_LENGTH = 5;
    private static final String LENGTH_OVER_EXCEPTION_MASSAGE_FORMAT = "%s 의 길이가 너무 깁니다.";
    private static final String BLANK_REWARD_EXCEPTION_MASSAGE = "보상을 명명할 때 공백을 넣을 수 없습니다.";

    private final String result;

    Reward(String result) {
        validReward(result);
        this.result = result;
    }

    private void validReward(String reward) {
        checkBlank(reward);
        if (reward.length() > MAX_REWARD_LENGTH) {
            throw new IllegalArgumentException(String.format(LENGTH_OVER_EXCEPTION_MASSAGE_FORMAT, reward));
        }
    }

    private void checkBlank(String result) {
        if (result.equals(BLANK)) {
            throw new IllegalArgumentException(BLANK_REWARD_EXCEPTION_MASSAGE);
        }
    }

    String getResult() {
        return result;
    }
}
