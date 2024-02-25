package laddergame.domain;

import static laddergame.domain.Players.PLAYER_NOT_FOUND_ERROR;

import java.util.LinkedHashMap;
import java.util.Map;

public record PlayersResults(LinkedHashMap<Player, Result> playerResults) {
    public Result find(final String playerName) {
        return playerResults.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(playerName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PLAYER_NOT_FOUND_ERROR));
    }
}
