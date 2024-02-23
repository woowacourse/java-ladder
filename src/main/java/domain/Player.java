package domain;

import util.ExceptionMessages;

public class Player {

    private static final int MAXIMUM_NAME = 5;
    private final String name;

    public Player(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
