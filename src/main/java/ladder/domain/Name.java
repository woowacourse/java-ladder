package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String UNAVAILABLE_NAME = "all";
    private static final String COMMA = ",";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotNull(name);
        validateDoesNotContainComma(name);
        validateLength(name);
        validateIsAvailable(name);
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new NullPointerException(ErrorMessage.NAME_IS_NULL.getMessage());
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

    private void validateIsAvailable(String name) {
        if (name.equals(UNAVAILABLE_NAME)) {
            throw new IllegalArgumentException(ErrorMessage.UNAVAILABLE_NAME.getMessage());
        }
    }

    public int length() {
        return name.length();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
