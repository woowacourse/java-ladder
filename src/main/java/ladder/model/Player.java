package ladder.model;

public class Player {

    private final PlayerName playerName;

    public Player(String playerName) {
        this.playerName = new PlayerName(playerName);
    }

    public boolean isSameName(String name) {
        if (playerName.getPlayerName().equals(name)) {
            return true;
        }
        return false;
    }

    public String getPlayerName() {
        return playerName.getPlayerName();
    }

}
