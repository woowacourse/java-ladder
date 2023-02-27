package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards = new ArrayList<>();

    public void add(Reward reward) {
        rewards.add(reward);
    }

    public List<String> getRewardNames() {
        return rewards.stream()
                .map(Reward::getReward)
                .collect(Collectors.toUnmodifiableList());
    }

    public Reward getRewardByIndex(int index) {
        return rewards.get(index);
    }

    public List<Reward> getRewardByIndex(List<Integer> indexes) {
        return indexes.stream()
                .map(rewards::get)
                .collect(Collectors.toUnmodifiableList());
    }
}
