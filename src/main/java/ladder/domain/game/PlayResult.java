package ladder.domain.game;

import ladder.domain.player.Player;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayResult {
    private final Map<String, String> result = new LinkedHashMap<>();

    public PlayResult(final List<Player> players, final List<String> prizes) {
        for (final Player player : players) {
            final int position = player.getPosition();
            result.put(player.getName(), prizes.get(position));
        }
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
