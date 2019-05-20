package ladder.domain;

import java.util.Map;

public class LadderResults {
    private final Map<String, String> results;

    public LadderResults(Map<String, String> results) {
        this.results = results;
    }

    public String result(String player) {
        if (player.equals(Player.FINISH_COMMAND)) {
            return all();
        }
        if (results.get(player) == null) {
            throw new IllegalArgumentException();
        }
        return results.get(player);
    }

    public String all() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : results.entrySet()) {
            stringBuilder.append(message(entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

    private String message(String player, String reward) {
        return new StringBuilder().append(player).append(" : ").append(reward).append("\n").toString();
    }
}
