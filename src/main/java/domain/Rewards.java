package domain;


import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {this.rewards = rewards;}

    public static Rewards from(List<String> rewards) {
        return new Rewards(rewards.stream()
                                  .map(Reward::new)
                                  .toList());
    }
}
