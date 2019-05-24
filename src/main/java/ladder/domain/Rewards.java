package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards implements Names {
    private final List<Reward> rewards;

    Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards from(List<String> names) {
        List<Reward> rewards = names.stream().map(name -> Reward.from(name)).collect(Collectors.toList());
        return new Rewards(rewards);
    }

    @Override
    public int size() {
        return rewards.size();
    }

    @Override
    public String getName(int i) {
        return rewards.get(i).getName();
    }
}
