package ladder;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    Map<Player, DrawResult> results;

    GameResult(){
        results = new HashMap<>();
    }


    public void addGameResult(Player player, DrawResult drawResult) {
        results.put(player, drawResult);
    }

    public DrawResult getResult(Player player) {
        return results.get(player);
    }
}
