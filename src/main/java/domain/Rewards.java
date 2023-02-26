package domain;

import java.util.List;
import java.util.stream.Collectors;
import utils.StringParser;

public class Rewards {

    private static final String REWARD_COUNT_ERROR = "[ERROR] 실행 결과 수는 사람 수와 같아야 합니다.";

    private final List<Reward> rewards;

    public Rewards(final List<Reward> rewards, final int userCount) {
        validate(rewards, userCount);
        this.rewards = List.copyOf(rewards);
    }

    private void validate(final List<Reward> rewards, final int userCount) {
        if (rewards.size() != userCount) {
            throw new IllegalArgumentException(REWARD_COUNT_ERROR);
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<String> getRewardNames() {
        return rewards.stream()
                .map(reward -> StringParser.insertBlank(reward.getRewardName()))
                .collect(Collectors.toUnmodifiableList());
    }
}
