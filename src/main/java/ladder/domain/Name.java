package ladder.domain;

import java.util.Objects;

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
        validateNotNull(name);
        validateDoesNotContainComma(name);
        validateLength(name);
        validateNameIsNotall(name);
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

    private void validateNameIsNotall(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_ALL.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name)o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
