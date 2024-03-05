package domain.ladder;

import domain.player.Player;
import domain.prize.Prize;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Player, Prize> results;

    public LadderResult(Map<Player, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public Prize findPrizeByPlayerName(String playerName) {
        Player player = new Player(playerName);
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 존재하지 않는 참가자입니다.", player.getName())
            );
        }
        return results.get(player);
    }

    public Map<Player, Prize> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}
