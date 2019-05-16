package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private List<String> rewards;

    public LadderRewards(String text, int width) {
//        this.rewards =
//        Arrays.asList(text.split(",")).
        rewards = Arrays.stream(text.split(","))
                .map(reward -> {
                    reward = reward.trim();
                    if (reward.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    return reward;
                })
                .collect(Collectors.toList());

        if (rewards.size() != width) {
            throw new IllegalArgumentException();
        }
    }

    String reward(int index) {
        return rewards.get(index);
    }

    public List<String> reward() {
        return rewards;
    }
}
