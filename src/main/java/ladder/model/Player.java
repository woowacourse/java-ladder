package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

public class Player {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String playerName;

    public Player(String playerName) {
        playerName = removeWhiteSpace(playerName);
        validatePlayerNameLength(playerName);
        this.playerName = playerName;
    }

    private String removeWhiteSpace(String playerName) {
        return playerName.replaceAll(" ", "");
    }

    private void validatePlayerNameLength(String playerName) {
        if (!isNameLengthIncludedInRange(playerName)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_NAME_LENGTH.getMessage());
        }
    }

    private boolean isNameLengthIncludedInRange(String playerName) {
        return MIN_LENGTH <= playerName.length() && playerName.length() <= MAX_LENGTH;
    }

    public String getPlayerName() {
        return playerName;
    }

}
