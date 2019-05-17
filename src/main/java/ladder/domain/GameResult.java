package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private Map<Player, DrawResult> results;

    GameResult() {
        results = new HashMap<>();
    }

    public void addGameResult(Player player, DrawResult drawResult) {
        results.put(player, drawResult);
    }

    public String getResult(String message) {
        if (message.equals("all")) {
            return this.toString();
        }
        return results.keySet()
                .stream()
                .filter(player -> player.getName().equals(message))
                .map(player -> results.get(player).getResult())
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        results.keySet().forEach(player -> stringBuilder.append(player.getName() + " : " + results.get(player).getResult() + "\n"));
        return stringBuilder.toString();
    }
}
