package model;

import exception.Message;

public class Player {
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.INVALID_PLAYER_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
