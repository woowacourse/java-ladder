package ladder.model;

import static ladder.model.ErrorMessage.*;

public class PlayerName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String playerName;

    public PlayerName(String playerName) {
        playerName = removeWhiteSpace(playerName);
        validatePlayerName(playerName);
        this.playerName = playerName;
    }

    private String removeWhiteSpace(String playerName) {
        return playerName.replaceAll(" ", "");
    }

    private void validatePlayerName(String playerName) {
        validatePlayerNameLength(playerName);
        validatePlayerNameRestricted(playerName);
    }

    private void validatePlayerNameLength(String playerName) {
        if (playerName.length() < MIN_LENGTH || playerName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_NAME_LENGTH.getMessage());
        }
    }

    private void validatePlayerNameRestricted(String playerName) {
        if (playerName.equals(Command.ALL.getCommand())) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_NAME_RESTRICTED_ALL.getMessage());
        }
        if (playerName.equals(Command.QUIT.getCommand())) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_NAME_RESTRICTED_QUIT.getMessage());
        }
    }

    public String getPlayerName() {
        return playerName;
    }

}
