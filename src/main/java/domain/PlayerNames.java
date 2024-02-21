package domain;

import common.exception.message.ExceptionMessage;

import java.util.List;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;

    public PlayerNames(List<PlayerName> playerNames) {
        if (playerNames.size() < PLAYER_NAMES_MIN_RANGE || playerNames.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAMES_RANGE_ERROR);
        }
        this.playerNames = playerNames;
    }
}
