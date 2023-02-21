package domain;

public class Reward {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private static void validateLength(String reward) {
        if (reward.length() < MIN_LENGTH || reward.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_REWARD_LENGTH_FORMAT.message);
        }
    }

    private static void validateBlank(String reward) {
        if (reward.isBlank()) {
            throw new IllegalArgumentException(Message.EXCEPTION_REWARD_BLANK.message);
        }
    }

    public String getReward() {
        return reward;
    }

    private void validate(String reward) {
        validateBlank(reward);
        validateLength(reward);
    }

    private enum Message {
        EXCEPTION_REWARD_LENGTH_FORMAT("%d 글자 이상 %d 글자 이하의 보상만 입력해주세요.", MIN_LENGTH, MAX_LENGTH),
        EXCEPTION_REWARD_BLANK("빈 문자열(공백)은 보상이 될 수 없습니다.");

        private static final String BASE_MESSAGE_FORMAT = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE_FORMAT, String.format(message, replaces));
        }
    }
}
