package ladder.model;

public class Result {

    private final Player player;
    private final Reward reward;

    public Result(Player player, Reward reward){
        this.player = player;
        this.reward = reward;
    }

    public Player getPlayer() {
        return player;
    }

    public Reward getReward() {
        return reward;
    }
}
