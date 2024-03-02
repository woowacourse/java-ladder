package domain;

import java.util.Map;

public class LadderGameResult {

    private final Map<Player, Result> ladderGameResult;

    public LadderGameResult(Map<Player, Result> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Result get(Player player) {
        return ladderGameResult.get(player);
    }
}
