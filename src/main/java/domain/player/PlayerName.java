package domain.player;

import domain.player.message.PlayerExceptionMessage;

public class PlayerName {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateIsBlank(name);
        validateNameLength(name);
    }

    private void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(PlayerExceptionMessage.PLAYER_NAME_BLANK);
        }
    }

    private void validateNameLength(final String name) {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(PlayerExceptionMessage.PLAYER_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
