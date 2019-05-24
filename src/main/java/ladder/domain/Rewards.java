package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> names) {
        List<Reward> rewards = names.stream().map(name -> Reward.from(name)).collect(Collectors.toList());
        return new Rewards(rewards);
    }

    public int size() {
        return rewards.size();
    }
}
