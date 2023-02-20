package ladder.domain;

import java.util.regex.Pattern;

public class Gift {
    private static final Pattern BOOM_PATTERN = Pattern.compile("^[꽝]$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final int MINIMUM_SIZE = 2;
    private static final int MAXIMUM_SIZE = 5;

    private String value;

    public Gift(String value) {
        String trimValue = value.trim();
        validate(trimValue);
        this.value = trimValue;
    }

    private void validate(String value) {
        validateFormat(value);
        validateLength(value);
    }


    private void validateFormat(String value) {
        if (isNotMatchBoom(value) && isNotMatchNumber(value)) {
            throw new IllegalArgumentException("상품 이름은 꽝 혹은 숫자여야 합니다.");
        }
    }

    private boolean isNotMatchBoom(String value) {
        return !BOOM_PATTERN.matcher(value).matches();
    }

    private boolean isNotMatchNumber(String value) {
        return !NUMBER_PATTERN.matcher(value).matches();
    }

    private void validateLength(String value) {
        if (isSmallSize(value) || isLargeSize(value)) {
            throw new IllegalArgumentException("상품 이름은 2 이상 5 이하여야 합니다.");
        }
    }

    private boolean isSmallSize(String value) {
        return MINIMUM_SIZE > value.length();
    }

    private boolean isLargeSize(String value) {
        return MAXIMUM_SIZE < value.length();
    }

    public String getName() {
        return value;
    }
}
