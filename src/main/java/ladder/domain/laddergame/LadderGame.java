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

    private void checkNumberOfRewards(Players players, Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new IllegalArgumentException("Player 수와 reward 의 수가 같아야합니다.");
        }
    }

    private Map<Player, Reward> calculateReward(Players players, Rewards rewards) {
        Map<Player, Reward> result = new HashMap<>();
        for (int start = 0; start < players.size(); start++) {
            int current = start;
            current = takeLadder(current);
            result.put(players.get(start), rewards.get(current));
        }
        return result;
    }

    private int takeLadder(int current) {
        for (int j = 0; j < ladder.getHeight(); j++) {
            current += ladder.get(j).move(current);
        }
        return current;
    }
}
