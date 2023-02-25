package ladder.domain;

import java.util.regex.Pattern;

public class Gift {

    private static final Pattern BOOM_PATTERN = Pattern.compile("^[꽝]$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final int MINIMUM_SIZE = 1;
    private static final int MAXIMUM_SIZE = 5;
    private static final String BLANK_ERROR_MESSAGE = "상품 이름을 작성해야 합니다.";
    private static final String INVALID_FORMAT_ERROR_MESSAGE = "상품 이름은 꽝 혹은 숫자여야 합니다.";
    private static final String GIFT_LENGTH_ERROR_MESSAGE =
            "상품 이름은 " + MINIMUM_SIZE + " 이상 " + MAXIMUM_SIZE + " 이하여야 합니다.";

    private String value;

    public Gift(final String value) {
        String trimValue = value.trim();
        validate(trimValue);
        this.value = trimValue;
    }

    private void validate(final String value) {
        validateIsBlank(value);
        validateFormat(value);
        validateLength(value);
    }

    private void validateIsBlank(final String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }


    private void validateFormat(final String value) {
        if (isNotMatchBoom(value) && isNotMatchNumber(value)) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    private boolean isNotMatchBoom(final String value) {
        return !BOOM_PATTERN.matcher(value).matches();
    }

    private boolean isNotMatchNumber(final String value) {
        return !NUMBER_PATTERN.matcher(value).matches();
    }

    private void validateLength(final String value) {
        if (isSmallSize(value) || isLargeSize(value)) {
            throw new IllegalArgumentException(GIFT_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isSmallSize(final String value) {
        return MINIMUM_SIZE > value.length();
    }

    private boolean isLargeSize(final String value) {
        return MAXIMUM_SIZE < value.length();
    }

    public String getName() {
        return value;
    }
}
