package domain;

import static message.ErrorMessage.INVALID_PLAYER_COUNT_EXCEPTION;
import static message.ErrorMessage.OVERLAP_PAYER_NAME_EXCEPTION;

import java.util.List;
import java.util.stream.IntStream;

public class PlayerNames {

    private static final int MINIMUM_PLAYER_COUNT = 2;

    private final List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNames) {
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
        return IntStream.range(0, playerNames.size())
                .filter(i -> playerNames.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);
    }

    public boolean isExistPlayer(String name) {
        return playerNames.stream().anyMatch(playerName -> playerName.isEqualName(name));
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }
}
