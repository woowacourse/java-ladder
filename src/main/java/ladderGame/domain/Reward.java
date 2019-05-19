package ladderGame.domain;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return reward;
    }
}
