package model;

import exception.Message;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
