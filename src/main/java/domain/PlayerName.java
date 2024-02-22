package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

public class PlayerName {
    private String name;

    public PlayerName(final String name) {
        validateIsBlank(name);
        this.name = name;
    }

    private void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
