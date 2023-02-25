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
    public boolean isSameNameWithInput(String input){
        return this.name.equals(input);
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public Reward getReward() {
        return reward;
    }

    public String getRewardName() {
        return reward.getRewardName();
    }
}
