package domain;

public class Player {

    private final PlayerName playerName;
    private String result;

    public Player(final String playerName) {
        this.playerName = new PlayerName(playerName);
        this.result = null;
    }

    public String getName() {
        return this.playerName.getName();
    }

    public int getLengthOfPlayerName() {
        return this.playerName.getLengthOfName();
    }

    public void addResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
