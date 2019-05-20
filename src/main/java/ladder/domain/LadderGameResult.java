package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    Map<Player, Reward> ladderGameResult;

    public LadderGameResult(Map<Player, Reward> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Reward findReward(Player player) {
        return ladderGameResult.get(player);
    }

    public Set<Player> keySet(){
        return ladderGameResult.keySet();
    }

    public Map<Player, Reward> getLadderGameResult() {
        return Collections.unmodifiableMap(ladderGameResult);
    }
}
