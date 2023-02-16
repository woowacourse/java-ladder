package domain;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
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
            throw new IllegalArgumentException("5글자 이하를 입력해주세요.");
        }
    }

    private static void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("한글자 이상 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object name) {
        if (this == name) return true;
        if (name == null || getClass() != name.getClass()) return false;
        Name anotherName = (Name) name;
        return this.name.equals(anotherName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
