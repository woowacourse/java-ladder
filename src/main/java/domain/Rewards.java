package domain;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private static final String EXCEPTION_COUNT_MESSAGE = "[ERROR] 보상의 개수는 사용자의 수와 동일해야 합니다.";
    private static final String REWARD_DELIMITER = ",";

    private final List<Reward> rewards;

    public Rewards(String rewards, int personCount) {
        this.rewards = new ArrayList<>();
        String[] splitRewards = rewards.split(REWARD_DELIMITER);
        validate(splitRewards.length, personCount);
        addRewards(splitRewards);
    }

    private static void validate(int rewardCount, int personCount) {
        if (rewardCount != personCount) {
            throw new IllegalArgumentException(EXCEPTION_COUNT_MESSAGE);
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    private void addRewards(String[] splitRewards) {
        for (String reward : splitRewards) {
            this.rewards.add(new Reward(reward));
        }
    }
}
