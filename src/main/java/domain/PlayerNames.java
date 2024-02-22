
package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;
import java.util.List;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;

    public PlayerNames(final List<PlayerName> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames;
    }

    private void validate(final List<PlayerName> playerNames) {
        validateDuplication(playerNames);
        validateRange(playerNames);
    }

    private void validateRange(final List<PlayerName> playerNames) {
        if (playerNames.size() < PLAYER_NAMES_MIN_RANGE || playerNames.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_RANGE);
        }
    }

    private void validateDuplication(final List<PlayerName> playerNames) {
        int playerCount = playerNames.size();
        long distinctCount = playerNames.stream().map(PlayerName::getName).distinct().count();

        if (playerCount != distinctCount) {
            throw new ValidationException(ExceptionMessage.PLAYER_NAMES_DUPLICATION);
        }
    }

    public int getCount() {
        return playerNames.size();
    }

    public String getNameOfIndex(final int index) {
        return playerNames.get(index).getName();
    }
}
