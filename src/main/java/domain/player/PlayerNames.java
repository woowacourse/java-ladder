package domain.player;

import java.util.List;

public class PlayerNames {
    public static final int PLAYER_NAMES_MIN_RANGE = 2;
    public static final int PLAYER_NAMES_MAX_RANGE = 10;
    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PLAYER_NAMES_MIN_RANGE, PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";

    private final List<PlayerName> playerNames;

    public PlayerNames(final List<PlayerName> playerNames) {
        validate(playerNames);
        this.playerNames = List.copyOf(playerNames);
    }

    private void validate(final List<PlayerName> playerNames) {
        validateDuplication(playerNames);
        validateRange(playerNames);
    }

    private void validateRange(final List<PlayerName> playerNames) {
        if (playerNames.size() < PLAYER_NAMES_MIN_RANGE || playerNames.size() > PLAYER_NAMES_MAX_RANGE) {
            throw new IllegalArgumentException(PLAYER_NAMES_RANGE);
        }
    }

    private void validateDuplication(final List<PlayerName> playerNames) {
        int playerCount = playerNames.size();
        long distinctCount = playerNames.stream()
                .map(PlayerName::getValue)
                .distinct()
                .count();

        if (playerCount != distinctCount) {
            throw new IllegalArgumentException(PLAYER_NAMES_DUPLICATION);
        }
    }

    public int getPlayerCount() {
        return playerNames.size();
    }

    public PlayerName getPlayerNameOfIndex(final int index) {
        return playerNames.get(index);
    }

    public boolean isParticipate(final String playerName) {
        return playerNames.stream()
                .anyMatch(name -> name.getValue().equals(playerName));
    }
}
