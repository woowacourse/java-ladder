package domain;

import constant.domain.NameExceptionMessage;

import java.util.Objects;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        validateForbidName(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NameExceptionMessage.NO_NAME.getExceptionMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException(NameExceptionMessage.OUT_OF_RANGE_NAME_LENGTH.getExceptionMessage());
        }
    }

    private void validateForbidName(String name) {
        if (Command.contains(name)) {
            throw new IllegalArgumentException(NameExceptionMessage.DISALLOWED_NAME.getExceptionMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
