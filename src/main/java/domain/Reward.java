package domain;

import java.util.regex.Pattern;

public class Reward {

    private static final int REWARD_MIN_SIZE_INCLUSIVE = 1;
    private static final int REWARD_MAX_SIZE_INCLUSIVE = 5;
    private static final String REWARD_SIZE_ERROR_MESSAGE = "상품은 1 ~ 5 글자여야 합니다.";
    private static final String VALUE_ERROR_MESSAGE = "이름은 영어나 숫자로만 가능합니다.";
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final String name;

    public Reward(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateWord(name);
    }

    private void validateLength(String name) {
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException(REWARD_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(String name) {
        return !(REWARD_MIN_SIZE_INCLUSIVE <= name.length()
                && name.length() <= REWARD_MAX_SIZE_INCLUSIVE);
    }

    private void validateWord(String name) {
        if (isNotMatches(name)) {
            throw new IllegalArgumentException(VALUE_ERROR_MESSAGE);
        }
    }

    private boolean isNotMatches(String name) {
        return !PLAYER_NAME_PATTERN.matcher(name).matches();
    }

    public String getName() {
        return this.name;
    }

}
