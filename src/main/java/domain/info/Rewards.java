package domain.info;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private static final int MIN_REWARDS_COUNT = 2;
    private static final int MAX_REWARDS_COUNT = 100;

    private final List<Reward> rewards;

    public Rewards(final List<String> rewards) {
        validate(rewards.size());
        this.rewards = generateRewards(rewards);
    }

    private static void validate(final int rewardsSize) {
        if (rewardsSize < MIN_REWARDS_COUNT || rewardsSize > MAX_REWARDS_COUNT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보상의 개수는 %d개 이상 %d개 이하여야 합니다.", MIN_REWARDS_COUNT, MAX_REWARDS_COUNT)
            );
        }
    }

    private static List<Reward> generateRewards(final List<String> rewards) {
        List<Reward> result = new ArrayList<>();

        for (String reward : rewards) {
            result.add(new Reward(reward));
        }

        return result;
    }

    public List<Reward> getRewards() {
        return List.copyOf(rewards);
    }

    public Reward getReward(final int index) {
        return rewards.get(index);
    }

    public int getRewardsSize() {
        return rewards.size();
    }
}
