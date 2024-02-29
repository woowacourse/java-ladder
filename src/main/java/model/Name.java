package model;

import java.util.Objects;

public class Name {

    private static final String NULL_EMPTY_NAME = "참가자의 이름은 null 이거나 공백일 수 없습니다.";
    private static final String NOT_ALL_NAME = "참가자의 이름은 all일 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String OVER_LENGTH_NAME = "참가자의 이름은 최대 %d글자입니다.".formatted(MAX_NAME_LENGTH);

    private final String value;

    public Name(String value) {
        validateNameNullAndBlank(value);
        validateNameLength(value);
        validateIsAll(value);
        this.value = value;
    }

    private static void validateNameNullAndBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NULL_EMPTY_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_LENGTH_NAME);
        }
    }

    private void validateIsAll(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException(NOT_ALL_NAME);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
