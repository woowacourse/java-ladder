package domain;

import java.util.regex.Pattern;

public class Reward {

    private static final int REWARD_MIN_SIZE_INCLUSIVE = 1;
    private static final int REWARD_MAX_SIZE_INCLUSIVE = 5;
    private static final String REWARD_SIZE_ERROR_MESSAGE = "상품은 1 ~ 5 글자여야 합니다.";
    private static final String VALUE_ERROR_MESSAGE = "이름은 영어나 숫자로만 가능합니다.";
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        validateLength(reward);
        validateWord(reward);
    }

    private void validateLength(String reward) {
        if (isOutOfRange(reward)) {
            throw new IllegalArgumentException(REWARD_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(String reward) {
        return !(REWARD_MIN_SIZE_INCLUSIVE <= reward.length()
                && reward.length() <= REWARD_MAX_SIZE_INCLUSIVE);
    }

    private void validateWord(String reward) {
        if (isNotMatches(reward)) {
            throw new IllegalArgumentException(VALUE_ERROR_MESSAGE);
        }
    }

    private boolean isNotMatches(String reward) {
        return PLAYER_NAME_PATTERN.matcher(reward).matches();
    }

}
