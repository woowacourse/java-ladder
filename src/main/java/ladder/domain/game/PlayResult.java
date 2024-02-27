package ladder.domain.game;

import ladder.domain.player.Player;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayResult {
    private final Map<String, String> result;

    PlayResult(final Map<String, String> result) {
        this.result = new LinkedHashMap<>(result);
    }

    public PlayResult(final List<Player> players, final List<String> prizes) {
        this.result = recordResult(players, prizes);
    }

    private Map<String, String> recordResult(final List<Player> players, final List<String> prizes) {
        final Map<String, String> result = new LinkedHashMap<>();

        for (final Player player : players) {
            final int position = player.getPosition();
            result.put(player.getName(), prizes.get(position));
        }

        return result;
    }

    public String findByName(final String name) {
        return result.get(name);
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
