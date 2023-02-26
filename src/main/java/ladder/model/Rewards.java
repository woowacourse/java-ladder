package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<Reward> rewards, int playerCount) {
        validate(rewards.size(), playerCount);

        return new Rewards(rewards);
    }

    private static void validate(int rewardCount, int playerCount) {
        if (rewardCount != playerCount) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_REWARD_COUNT.getMessage());
        }
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public Reward getReward(int index){
        return rewards.get(index);
    }

}
