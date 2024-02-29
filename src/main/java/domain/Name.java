package domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 2;
    private static final String INVALID_NAME_LENGTH =
            "이름은 " + MIN_NAME_LENGTH + "자 이상, " + MAX_NAME_LENGTH + "자 이하여야 합니다.";
    public static final String NAME_CONTAINS_BLANK = "이름은 비어있거나 공백을 포함할 수 없습니다.";
    public static final String BLANK = " ";

    private final String value;

    public Name(final String value) {
        validateNameLength(value);
        this.value = value;
    }

    private void validateNameLength(final String value) {
        validateNameIsNotNull(value);
        validateNameLengthUnderUpperBound(value);
        validateNameLengthOverLowerBound(value);
        validateNameIsNotBlank(value);
    }

    private void validateNameIsNotNull(final String value) {
        if (value == null) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private static void validateNameLengthUnderUpperBound(final String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private static void validateNameLengthOverLowerBound(final String value) {
        if (value.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private static void validateNameIsNotBlank(final String value) {
        if (value.contains(BLANK)) {
            throw new IllegalArgumentException(NAME_CONTAINS_BLANK);
        }
    }

    public String getValue() {
        return value;
    }
}
