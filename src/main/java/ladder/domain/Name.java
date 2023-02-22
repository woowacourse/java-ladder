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

    public int length() {
        return name.length();
    }

    private void validate(String name) {
        validateNotNull(name);
        validateDoesNotContainComma(name);
        validateLength(name);
        validateDoesNotEqualUnavailable(name);
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NULL.getMessage());
        }
    }

    private void validateDoesNotContainComma(String name) {
        if (name.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private void validateDoesNotEqualUnavailable(String name) {
        if (name.equals(UnavailableName.ALL.value) ||
                name.equals(UnavailableName.EXIT.value)) {
            throw new IllegalArgumentException(ErrorMessage.UNAVAILABLE_NAME.getMessage());
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    private enum UnavailableName {
        ALL("all"),
        EXIT("exit");

        final String value;

        UnavailableName(String value) {
            this.value = value;
        }
    }
}
