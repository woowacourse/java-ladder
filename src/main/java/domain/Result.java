package domain;

public class Result {

    private final Player player;
    private final Reward reward;

    public Result(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Reward getReward() {
        return this.reward;
    }
}
