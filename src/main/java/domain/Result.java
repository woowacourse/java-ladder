package domain;

public class Result {

    private final PlayerName playerName;
    private final Reward reward;

    public Result(PlayerName playerName, Reward reward) {
        this.playerName = playerName;
        this.reward = reward;
    }

    public PlayerName getPlayerName() {
        return this.playerName;
    }

    public Reward getReward() {
        return this.reward;
    }
}
