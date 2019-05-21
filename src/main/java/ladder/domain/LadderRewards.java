package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.List;

public class LadderRewards {
    private List<String> rewards;

    public LadderRewards(List<String> inputRewards, int width) {
        if (inputRewards.size() == 0) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
        }
        if (inputRewards.contains("")) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_BLANK.message());
        }
        if (inputRewards.size() != width) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_REWARD_COUNT.message());
        }
        rewards = inputRewards;
    }

    String reward(int index) {
        return rewards.get(index);
    }

    public List<String> reward() {
        return rewards;
    }
}
