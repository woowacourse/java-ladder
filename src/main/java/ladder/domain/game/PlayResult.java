package ladder.domain.game;

import ladder.domain.player.Player;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayResult {
    private final Map<String, Integer> result = new LinkedHashMap<>();

    public PlayResult(final List<Player> players) {
        for (final Player player : players) {
            final String name = player.getName();
            final int position = player.getPosition();

            result.put(name, position);
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
