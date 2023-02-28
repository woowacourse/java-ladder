package domain;

import java.util.Objects;

public class User {
    private static final int USER_NAME_MIN_LENGTH = 1;
    private static final int USER_NAME_MAX_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 1~5 글자만 가능합니다.";
    private static final String INVALID_NAME_BLANK_MESSAGE = "이름은 공백으로만 이루어지면 안됩니다.";
    private final String name;

    public User(final String name) {
        validateNameLength(name);
        validateBlankName(name);

        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (USER_NAME_MIN_LENGTH > name.length() || USER_NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private void validateBlankName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
