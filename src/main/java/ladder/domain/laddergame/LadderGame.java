package ladder.domain.laddergame;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderGameResult play(Players players, Rewards rewards) {
        checkNumberOfRewards(players, rewards);
        return new LadderGameResult(calculateReward(players, rewards));
    }

    private Map<Player, Reward> calculateReward(Players players, Rewards rewards) {
        Map<Player, Reward> result = new HashMap<>();
        for (int startPoint = 0; startPoint < players.size(); startPoint++) {
            int currentLocation = startPoint;
            currentLocation = takeLadder(currentLocation);
            result.put(players.get(startPoint), rewards.get(currentLocation));
        }
        return result;
    }

    private int takeLadder(int currentLocation) {
        for (int j = 0; j < ladder.getHeight(); j++) {
            currentLocation += ladder.get(j).get(currentLocation).getDirection();
        }
        return currentLocation;
    }

    private void checkNumberOfRewards(Players players, Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new IllegalArgumentException("Player 수와 reward 의 수가 같아야합니다.");
        }
    }
}
