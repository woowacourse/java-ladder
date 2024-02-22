package domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 2;
    private static final String INVALID_NAME_LENGTH = "이름은 2자 이상, 5자 이하여야 합니다.";

    private final String name;

    public Name(String value) {
        validateNameLength(value);
        this.name = value;
    }

    private void validateNameLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }

        if (value.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getValue() {
        return name;
    }
}
