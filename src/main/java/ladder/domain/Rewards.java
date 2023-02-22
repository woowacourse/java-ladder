package ladder.domain;

import java.util.List;

public class Rewards {

    private final List<String> rewards;

    public Rewards(int numberOfPlayers, List<String> rewards) {
        validateNumberOfRewards(numberOfPlayers, rewards);
        validateBlankRewards(rewards);
        this.rewards = rewards;
    }

    private void validateNumberOfRewards(int numberOfPlayers, List<String> rewards) {
        if (numberOfPlayers != rewards.size()) {
            throw new IllegalArgumentException("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }
    }

    private void validateBlankRewards(List<String> rewards) {
        for (String reward : rewards) {
            if (reward.isBlank()) {
                throw new IllegalArgumentException("보상을 입력하지 않았습니다.");
            }
        }
    }
}
