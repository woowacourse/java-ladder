package domain.player;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotBlank(name);
        validateNameLength(name);
        validateStripedName(name);
        validateNameIsNotAll(name);
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈 값을 이름으로 사용할 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
    }

    private void validateStripedName(String name) {
        if (!name.strip().equals(name)) {
            throw new IllegalArgumentException("앞,뒤 공백을 포함한 글자를 이름으로 사용할 수 없습니다.");
        }
    }

    private void validateNameIsNotAll(String name) {
        if (name.equalsIgnoreCase("all")) {
            throw new IllegalArgumentException("all 이라는 문자열은 이름으로 사용할 수 없습니다.");
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
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
