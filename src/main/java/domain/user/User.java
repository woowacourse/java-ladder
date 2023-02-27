package domain.user;

import exception.ErrorMessage;
import java.util.Objects;

public class User {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(final String name) {
        validateLength(name);
        validateBlank(name);
        validateName(name);
        this.name = name;
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

    private void validateName(final String name) {
        if (name.equals(Users.ALL_USERS)) {
            throw new IllegalArgumentException(ErrorMessage.USER_NAME_IS_ALL_EXCEPTION.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(final String name) {
        return this.name.equals(name);
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
