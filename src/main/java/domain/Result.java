package domain;

public class Result {

    private final String playerName;
    private final String rewardName;

    public Result(final String rewardName) {
        playerName = null;
        this.rewardName = rewardName;
    }

    public Result(final String playerName, final String rewardName) {
        this.playerName = playerName;
        this.rewardName = rewardName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getRewardName() {
        return rewardName;
    }
}
