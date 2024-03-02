package domain.ladder;

import static java.util.stream.Collectors.toMap;

import domain.player.Player;
import domain.prize.Prize;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private final Map<Player, Prize> results;

    public LadderResult(Map<Player, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public String findPrizeByName(String playerName) {
        Player player = new Player(playerName);
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %s - 존재하지 않는 참가자입니다.", player.getName())
            );
        }
        Prize prize = results.get(player);
        return prize.getName();
    }

    public Map<String, String> getAllResults() {
        return results.entrySet()
                .stream()
                .collect(toMap(e -> e.getKey().getName(),
                        e -> e.getValue().getName(),
                        (a, b) -> b,
                        LinkedHashMap::new));
    }
}
