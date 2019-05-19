package laddergame.domain;

import laddergame.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final int MIN_REWARDS = 2;

    private List<Reward> rewards;

    public Rewards(List<String> names) {
        Validator.checkNumberOfNames(names, MIN_REWARDS);

        rewards = names.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public Reward get(int index) {
        return rewards.get(index);
    }

    public List<String> getRewardsNames() {
        return rewards.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }

    public int size() {
        return rewards.size();
    }
}
