package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(int numberOfPlayers, List<String> rewards) {
        validateNumberOfRewards(numberOfPlayers, rewards);

        this.rewards = createRewardsBy(rewards);
    }

    private void validateNumberOfRewards(int numberOfPlayers, List<String> rewards) {
        if (numberOfPlayers != rewards.size()) {
            throw new IllegalArgumentException("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }
    }

    private List<Reward> createRewardsBy(List<String> rewards) {
        return rewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public Reward findRewardBy(int index) {
        return rewards.get(index);
    }

    public List<String> findRewards() {
        return rewards.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }

}
