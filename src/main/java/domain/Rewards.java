package domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards = new ArrayList<>();

    public void add(Reward reward) {
        rewards.add(reward);
    }
}
