package domain;

import static message.ErrorMessage.INVALID_PLAYER_COUNT_EXCEPTION;
import static message.ErrorMessage.OVERLAP_PAYER_NAME_EXCEPTION;

import java.util.List;

public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;

    private final List<PlayerName> playerNames;

    public Players(List<PlayerName> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames;
    }

    private void validate(List<PlayerName> playerNames) {
        validatePlayerOverlap(playerNames);
        validatePlayerSize(playerNames);
    }

    private void validatePlayerOverlap(List<PlayerName> playerNames) {
        long distinctSize = playerNames.stream().map(PlayerName::getName).distinct().count();
        if (playerNames.size() != distinctSize) {
            throw new IllegalArgumentException(OVERLAP_PAYER_NAME_EXCEPTION.getMessage());
        }
    }

    private void validatePlayerSize(List<PlayerName> playerNames) {
        if (playerNames.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNT_EXCEPTION.getMessage());
        }
    }

    public int getPlayerNameOrderNumber(String name) {
        for (int i = 0; i < playerNames.size(); i++) {
            if (playerNames.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public List<PlayerName> getPlayersNames() {
        return playerNames;
    }

    public boolean isExistPlayer(String name) {
        for (PlayerName playerName : playerNames) {
            if (playerName.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
