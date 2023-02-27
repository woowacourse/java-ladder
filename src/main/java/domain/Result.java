package domain;

public class Result {

    private final String prize;
    private String playerName;

    public Result(String prize) {
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void savePlayer(String playerName) {
        this.playerName = playerName;
    }
}
