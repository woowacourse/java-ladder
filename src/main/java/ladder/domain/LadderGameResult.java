package ladder.domain;

import java.util.Map;

public class LadderGameResult {
    Map<Player, Reward> ladderGameResult;

    public LadderGameResult(Map<Player, Reward> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Reward findReward(Player player) {
        return ladderGameResult.get(player);
    }

    public Map<Player, Reward> getLadderGameResult() {
        return ladderGameResult;
    }
}
