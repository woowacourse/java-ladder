package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 이름에 대해 상품 결과를 만들어내는 게 도메인 로직일까
 * 아니면 view 로직일까
 */
public class GameResultProcessor {
    private final Map<String, String> result;

    private GameResultProcessor(Map<String, String> result) {
        this.result = result;
    }

    public static GameResultProcessor process(Map<Player, Position> ladderResult, Prizes prizes) {
        Map<String, String> result = ladderResult.keySet()
                                                 .stream()
                                                 .collect(Collectors.toMap(Player::getName, player -> {
                                                     Position position = ladderResult.get(player);
                                                     return prizes.get(position)
                                                                  .getName();
                                                 }));
        return new GameResultProcessor(result);
    }

    public Map<String, String> fetchAllResults() {
        return Collections.unmodifiableMap(result);
    }
}
