package domain;

import java.util.Objects;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;
    public static final String EXIT = "종료";

    private final String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        validateUnavailableName(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름이 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 " + MAX_OF_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }

    private void validateUnavailableName(String name) {
        if (name.equals(EXIT)) {
            throw new IllegalArgumentException("[ERROR] 이름에는 종료 키워드를 사용할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name other = (Name) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
