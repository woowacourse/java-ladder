package laddergame.result;

import laddergame.player.Player;
import laddergame.util.NullChecker;
import laddergame.vo.Position;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> result;

    private GameResult(Map<String, String> result) {
        this.result = result;
    }

    public static GameResult of(Map<Player, Position> ladderResult, Prizes prizes) {
        Map<String, String> gameResult = new HashMap<>();

        for (Player player : ladderResult.keySet()) {
            Position position = ladderResult.get(player);
            String playerName = player.getName();
            String prizeName = prizes.getPrizeName(position);
            gameResult.put(playerName, prizeName);
        }

        return new GameResult(gameResult);
    }

    public Map<String, String> fetchAllResults() {
        return Collections.unmodifiableMap(result);
    }

    public String fetchResultByName(String name) {
        String found = result.getOrDefault(name, null);
        NullChecker.checkNull(found, "잘못된 이름입니다.");

        return found;
    }
}
