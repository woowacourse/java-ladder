package domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {

    private static final int PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE = 2;
    private static final int PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = 20;
    public static final String PLAYER_NUMBER_RANGE_ERROR_MESSAGE = "참여자 수는 2 ~ 20명만 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATION_ERROR_MESSAGE = "이름은 중복될 수 없습니다.";

    private final List<PlayerName> playerNames;

    private PlayerNames(List<PlayerName> playerNames) {
        validate(playerNames);
        this.playerNames = playerNames;
    }

    public static PlayerNames from(List<String> names) {
        List<PlayerName> playerNames = names.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());

        return new PlayerNames(playerNames);
    }

    private void validate(List<PlayerName> playerNames) {
        validateDuplication(playerNames);
        validatePlayerNumber(playerNames.size());
    }

    private void validateDuplication(List<PlayerName> playerNames) {
        int duplicationSize = playerNames.stream()
                .map(PlayerName::getPlayerName)
                .collect(Collectors.toSet())
                .size();

        if (duplicationSize != playerNames.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validatePlayerNumber(int playerNumber) {
        if (isOutOfRange(playerNumber)) {
            throw new IllegalArgumentException(PLAYER_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int playerNumber) {
        return !(PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE <= playerNumber
                && playerNumber <= PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    public List<PlayerName> getPlayerNames() {
        return this.playerNames;
    }

    public int getSize() {
        return playerNames.size();
    }

}
