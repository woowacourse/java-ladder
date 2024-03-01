package domain.ladder;

import static java.util.stream.Collectors.toMap;

import domain.player.Player;
import domain.prize.Prize;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    private static final String NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE = "[ERROR] 잘못된 참가자명: %s - 존재하지 않는 참가자입니다.";

    private final Map<Player, Prize> results;

    public LadderResult(Map<Player, Prize> results) {
        this.results = new LinkedHashMap<>(results);
    }

    public String findPrizeByName(String playerName) {
        Player player = new Player(playerName);
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException(
                    String.format(NOT_EXISTING_PLAYER_EXCEPTION_MESSAGE, player.getName())
            );
        }

        return results.get(player).getName();
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
