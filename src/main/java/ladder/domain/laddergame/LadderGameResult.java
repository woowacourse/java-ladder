package ladder.domain.laddergame;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    Map<Player, Reward> ladderGameResult;

    public LadderGameResult(Map<Player, Reward> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Reward findReward(String name) {
        return ladderGameResult.get(new Player(name));
    }

    public Set<Player> keySet(){
        return ladderGameResult.keySet();
    }
}
