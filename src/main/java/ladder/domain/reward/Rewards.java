package ladder.domain.reward;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> rewards = new ArrayList<>();

    private Rewards() {}

    public static Rewards create(List<String> inputRewards, int playerCount) {
        validateSize(inputRewards, playerCount);
        List<Reward> inputToReward = inputRewards.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        Rewards createdRewards = new Rewards();
        createdRewards.rewards.addAll(inputToReward);
        return createdRewards;
    }

    public Reward findRewardByIndex(int index) {
        return rewards.get(index);
    }

    private static void validateSize(List<String> inputRewards, int playerCount) {
        if (inputRewards.size() != playerCount) {
            throw new IllegalArgumentException("보상은 참가자와 동일한 갯수를 입력해주세요.");
        }
    }

}
