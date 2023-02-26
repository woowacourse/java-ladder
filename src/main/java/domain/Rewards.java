package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private static final String REWARDS_SIZE_ERROR_MESSAGE = "상품 개수는 참여자 수와 동일하게 입력해야합니다.";
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards from(int numberOfPlayer, List<String> inputRewards) {
        validate(numberOfPlayer, inputRewards);
        List<Reward> rewards = inputRewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        return new Rewards(rewards);
    }

    private static void validate(int numberOfPlayer, List<String> inputRewards) {
        if (numberOfPlayer != inputRewards.size()) {
            throw new IllegalArgumentException(REWARDS_SIZE_ERROR_MESSAGE);
        }
    }

    public List<Reward> getRewards() {
        return List.copyOf(this.rewards);
    }

    public List<String> getRewardNames() {
        return this.rewards.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }

}
