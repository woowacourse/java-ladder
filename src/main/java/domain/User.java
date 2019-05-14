package domain;

import java.util.Objects;

public class User {
    private final String name;

    public User(final String name) {
        validateNameBlank(name);
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("생성자를 생성할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw  new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
