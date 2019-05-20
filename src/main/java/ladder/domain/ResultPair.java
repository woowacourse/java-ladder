package ladder.domain;

public class ResultPair<P, R> {
    private final P player;
    private final R reward;

    public ResultPair(final P player, final R reward) {
        this.player = player;
        this.reward = reward;
    }

    public boolean matchName(String name) {
        if (player instanceof Player) {
            return ((Player) player).matchName(name);
        }
        return false;
    }

    public String getReward() {
        if (reward instanceof Reward) {
            return reward.toString();
        }
        return "";
    }

    @Override
    public String toString() {
        return player.toString() + ":" + reward.toString();
    }
}