package domain;


import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {this.rewards = rewards;}

    public static Rewards from(List<String> rewards, int playerSize) {
        validate(rewards, playerSize);
        return new Rewards(rewards.stream()
                                  .map(Reward::new)
                                  .toList());
    }

    private static final void validate(List<String> rewards, int playerSize) {
        validateSize(rewards, playerSize);
    }

    private static final void validateSize(List<String> rewards, int playerSize) {
        if (rewards.size() != playerSize) {
            throw new IllegalArgumentException("플레이어 수와 보상의 수가 다릅니다.");
        }
    }

    public Reward getRewardAt(int index) {
        return rewards.get(index);
    }

    public List<Reward> getValue() {
        return rewards;
    }
}
