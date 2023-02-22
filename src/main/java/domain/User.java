package domain;

import static exception.ErrorMessage.*;

public class User {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public User(final String name) {
        validateLength(name);
        validateBlank(name);
        validateNotAll(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(USER_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(USER_NAME_BLANK_EXCEPTION.getMessage());
        }
    }

    private void validateNotAll(final String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException(USER_NAME_IS_ALL_EXCEPTION.getMessage());
        }
    }
}
