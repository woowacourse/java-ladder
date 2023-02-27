package domain.player;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    public static final String LENGTH_OVER_MAX_ERROR_MESSAGE = "5글자 이하를 입력해주세요.";
    public static final String LENGTH_BLACK_ERROR_MESSAGE = "한글자 이상 입력해주세요.";
    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateBlank(name);
        validateMaxLength(name);
    }

    private static void validateMaxLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_OVER_MAX_ERROR_MESSAGE);
        }
    }

    private static void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(LENGTH_BLACK_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return this.name;
    }

    @Override
    public boolean equals(final Object name) {
        if (this == name) {
            return true;
        }
        if (name == null || getClass() != name.getClass()) {
            return false;
        }
        Name anotherName = (Name) name;
        return this.name.equals(anotherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
