package domain;

import util.ExceptionMessages;

public class Name {

    private static final int MAXIMUM_NAME = 5;
    private final String value;

    public Name(final String value) {
        validateNameLength(value);
        this.value = value;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_LENGTH);
        }
    }

    public String getValue() {
        return value;
    }
}
