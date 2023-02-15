package domain;

import utils.constants.ErrorMessages;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
