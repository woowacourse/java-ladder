package ladder.domain;

class Name {

    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE =
            "이름은 1자 이상, " + NAME_LENGTH_UPPER_BOUND + "자 이하여야 합니다.";

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (isInvalidNameLength(value)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private boolean isInvalidNameLength(final String value) {
        return value == null || value.isBlank() || NAME_LENGTH_UPPER_BOUND < value.length();
    }

    public String getValue() {
        return value;
    }
}
