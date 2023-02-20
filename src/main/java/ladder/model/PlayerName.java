package ladder.model;

import static ladder.model.ErrorMessage.EXCEPTION_PLAYER_NAME_LENGTH;

public class PlayerName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String playerName;

    public PlayerName(String playerName) {
        playerName = removeWhiteSpace(playerName);
        validatePlayerNameLength(playerName);
        this.playerName = playerName;
    }

    private String removeWhiteSpace(String playerName) {
        return playerName.replaceAll(" ", "");
    }

    private void validatePlayerNameLength(String playerName) {
        if (playerName.length() < MIN_LENGTH || playerName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_NAME_LENGTH.getMessage());
        }
    }

    public String getPlayerName() {
        return playerName;
    }

}
