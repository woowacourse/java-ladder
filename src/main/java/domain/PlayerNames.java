
package domain;

import common.exception.message.ExceptionMessage;

import java.util.List;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;

    public PlayerNames(List<PlayerName> playerNames) {
        int playerCount = playerNames.size();
        long distinctCount = playerNames.stream().map(PlayerName::getName).distinct().count();
        if (playerCount != distinctCount) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAMES_DUPLICATION);
        }
        if (playerNames.size() < PLAYER_NAMES_MIN_RANGE || playerNames.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAMES_RANGE);
        }
        this.playerNames = playerNames;
    }

    public int getCount() {
        return playerNames.size();
    }

    public String getNameOfIndex(int index) {
        return playerNames.get(index).getName();
    }
}
