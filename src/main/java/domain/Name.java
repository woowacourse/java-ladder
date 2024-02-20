package domain;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        validateNameLength(name);
        validateNameCharacters(name);
        this.name = name;
    }

    private static void validateNameCharacters(String name) {
        if (name.matches("^[^a-zA-Z]+$")) {
            throw new RuntimeException("이름은 알파벳 대소문자로만 이루어져있어야 합니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new RuntimeException("이름의 길이는 1자 이상 5자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name other = (Name) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
