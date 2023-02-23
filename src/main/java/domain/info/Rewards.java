package domain.info;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private static final String EXCEPTION_COUNT_MESSAGE = "[ERROR] 보상의 개수는 사용자의 수와 동일해야 합니다.";

    private final List<Reward> rewards;

    public Rewards(List<String> rewards, Names names) {
        validate(rewards.size(), names.getNamesSize());
        this.rewards = generateRewards(rewards);
    }

    private static void validate(int rewardsSize, int namesSize) {
        if (rewardsSize != namesSize) {
            throw new IllegalArgumentException(EXCEPTION_COUNT_MESSAGE);
        }
    }

    private List<Reward> generateRewards(List<String> rewards) {
        List<Reward> result = new ArrayList<>();

        for (String reward : rewards) {
            result.add(new Reward(reward));
        }

        return result;
    }

    public List<Reward> getRewards() {
        return List.copyOf(rewards);
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }
}
