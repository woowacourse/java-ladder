package domain;

import java.util.Objects;

public class User {

    private static final String INVALID_NAME_ERROR = "[ERROR] 이름의 길이는 1 ~ 5글자 사이여야 합니다.";
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private final String name;

    public User(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
