package domain;

public class Player {
    private final PlayerName name;
    private Reward reward;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public String getName() {
        return name.getName();
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}
