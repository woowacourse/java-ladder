package ladder.domain.reward;

import ladder.domain.laddergame.Position;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rewards {


    private final Map<Position, RewardName> rewards;

    public Rewards(int numberOfPlayers, List<String> rewards) {
        validateNumberOfRewards(numberOfPlayers, rewards);

        this.rewards = createRewardsBy(numberOfPlayers, rewards);
    }

    private void validateNumberOfRewards(int numberOfPlayers, List<String> rewards) {
        if (numberOfPlayers != rewards.size()) {
            throw new IllegalArgumentException("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }
    }

    private Map<Position, RewardName> createRewardsBy(int numberOfPlayers, List<String> rewardNames) {
        Map<Position, RewardName> rewards = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            rewards.put(new Position(i), new RewardName(rewardNames.get(i)));
        }

        return rewards;
    }

//    private List<SecondReward> createRewardsBy(int numberOfPlayers, List<String> rewards) {
//        return IntStream.range(0, numberOfPlayers)
//                .mapToObj(i -> new SecondReward(new RewardName(rewards.get(i)), new SecondPosition(i)))
//                .collect(Collectors.toList());
//    }

    public RewardName findRewardBy(Position playerPosition) {
        if(!rewards.containsKey(playerPosition)) {
            throw new IllegalArgumentException("해당하는 보상이 없습니다.");
        }

        return rewards.get(playerPosition);
    }

    public List<String> findRewardNames() {
        List<String> rewardNames = new ArrayList<>();
        rewards.forEach(((position, rewardName) ->
                rewardNames.add(rewardName.getName())));

        return rewardNames;
    }
}
