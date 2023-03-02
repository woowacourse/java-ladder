package ladder.domain.reward;

import ladder.domain.laddergame.Position;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rewards {

    private final Map<Position, RewardName> positionAndRewards;

    public Rewards(final int numberOfPlayers, final List<String> rewards) {
        validateNumberOfRewards(numberOfPlayers, rewards);

        positionAndRewards = createRewardsBy(numberOfPlayers, rewards);
    }

    private void validateNumberOfRewards(final int numberOfPlayers, final List<String> rewards) {
        if (numberOfPlayers != rewards.size()) {
            throw new IllegalArgumentException("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }
    }

    private Map<Position, RewardName> createRewardsBy(final int numberOfPlayers, final List<String> rewardNames) {
        final Map<Position, RewardName> rewards = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            rewards.put(new Position(i), new RewardName(rewardNames.get(i)));
        }

        return rewards;
    }

    public RewardName findRewardBy(final Position playerPosition) {
        if (!positionAndRewards.containsKey(playerPosition)) {
            throw new IllegalArgumentException("해당하는 보상이 없습니다.");
        }

        return positionAndRewards.get(playerPosition);
    }

    public List<String> findRewardNames() {
        final List<String> rewardNames = new ArrayList<>();
        positionAndRewards.forEach(((position, rewardName) ->
                rewardNames.add(rewardName.getName())));

        return rewardNames;
    }

}
