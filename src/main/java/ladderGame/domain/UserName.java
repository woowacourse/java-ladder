package ladderGame.domain;

import java.util.Objects;

public class UserName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public UserName(String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 1자 이상 입력하세요.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw  new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

