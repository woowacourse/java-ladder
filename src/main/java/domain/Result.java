package domain;

public class Result {

    private final String playerName;
    private final String rewardName;

    public Result(Player playerName, Reward rewardName) {
        this.playerName = playerName.getName();
        this.rewardName = rewardName.getName();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getRewardName() {
        return this.rewardName;
    }

}
