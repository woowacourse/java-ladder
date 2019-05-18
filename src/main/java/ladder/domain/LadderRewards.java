package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private static final String DELIMITER = ",";
    private List<String> rewards;

    public LadderRewards(String text, int width) {
//        this.rewards =
//        Arrays.asList(text.split(",")).
        rewards = Arrays.stream(text.split(DELIMITER))
                .map(reward -> {
                    reward = reward.trim();
                    if (reward.isEmpty()) {
                        throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
                    }
                    return reward;
                })
                .collect(Collectors.toList());

        if (rewards.size() != width) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_REWARD_COUNT.message());
        }
    }

    String reward(int index) {
        return rewards.get(index);
    }

    public List<String> reward() {
        return rewards;
    }
}
