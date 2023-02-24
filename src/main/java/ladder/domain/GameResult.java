package ladder.domain;

import ladder.util.NullChecker;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 이름에 대해 상품 결과를 만들어내는 게 도메인 로직일까
 * 아니면 view 로직일까
 */
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
