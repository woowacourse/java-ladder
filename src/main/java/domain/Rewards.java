package domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    public static final String DELIMITER = ",";
    private final List<Reward> rewards;

    public Rewards(String inputRewards) {
        this.rewards = new ArrayList<>();
        createRewards(inputRewards);
    }

    private void createRewards(String inputRewards) {
        for (String input : List.of(inputRewards.split(DELIMITER))) {
            this.rewards.add(new Reward(input));
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
