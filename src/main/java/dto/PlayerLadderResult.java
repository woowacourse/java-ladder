package dto;

public class PlayerLadderResult {

    private final String playerName;
    private final String result;

    public PlayerLadderResult(String playerName, String result) {
        this.playerName = playerName;
        this.result = result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getResult() {
        return result;
    }
}
