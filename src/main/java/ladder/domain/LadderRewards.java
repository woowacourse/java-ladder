package ladder.domain;

import java.util.Arrays;
import java.util.List;

class LadderRewards {
    private List<String> rewards;

    LadderRewards(String text) {
        this.rewards = Arrays.asList(text.split(","));
    }

    String reward(int index) {
        return rewards.get(index);
    }
}
