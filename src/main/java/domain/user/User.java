package domain.user;

import exception.ErrorMessage;
import java.util.Objects;

public class User {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(final String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(final String name) {
        return this.name.equals(name);
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
