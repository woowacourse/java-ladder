package ladder.domain;

import ladder.error.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String COMMA = ",";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NULL.getMessage());
        }
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
        if (name.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}
