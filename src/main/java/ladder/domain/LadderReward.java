package ladder.domain;

import java.util.Arrays;
import java.util.List;

public class LadderReward {
    private List<String> rewards;

    public LadderReward(String text) {
        this.rewards = Arrays.asList(text.split(","));
    }

    public String reward(int index) {
        return rewards.get(index);
    }

    public int size() {
        return rewards.size();
    }
}
