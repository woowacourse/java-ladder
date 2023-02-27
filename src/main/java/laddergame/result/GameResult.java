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
            String playerName = player.getName();
            String prizeName = getPrizeName(ladderResult, player, prizes);
            gameResult.put(playerName, prizeName);
        }

        return new GameResult(gameResult);
    }

    private static String getPrizeName(Map<Player, Position> ladderResult, Player player, Prizes prizes) {
        Position destination = ladderResult.get(player);
        String prizeName = prizes.getPrizeName(destination.getPosition());
        return prizeName;
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
