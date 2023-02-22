package domain;

import domain.player.Players;

public class LadderResultRequest {

    private final String message;

    public LadderResultRequest(String message) {
        this.message = message;
    }

    public boolean isAll() {
        return message.equals("all");
    }

    public boolean isPlayerName(Players players) {
        return players.containPlayerBySpecificName(message);
    }

    public String getMessage() {
        return message;
    }
}
