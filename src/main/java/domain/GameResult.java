package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Player, String> playersResult = new HashMap<>();

    public void recordPlayersResult(Player player, Prizes prizes, int position) {
        playersResult.put(player, prizes.getPrizeByPosition(position));
    }

    public String getResultByPlayer(Player player) {
        return playersResult.get(player);
    }

    public Map<Player, String> getPlayersResult() {
        return Collections.unmodifiableMap(playersResult);
    }
}
