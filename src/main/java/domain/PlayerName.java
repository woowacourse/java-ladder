package domain;

import common.exception.message.ExceptionMessage;

public class PlayerName {
    private String name;

    public PlayerName(String name) {
        this.name = name;

        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
