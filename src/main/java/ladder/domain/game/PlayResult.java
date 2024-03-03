package ladder.domain.game;

import ladder.domain.player.Player;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayResult {
    private final Map<String, String> result;

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

    public String findPlayerResultByName(final String name) {
        if (result.containsKey(name)) {
            return result.get(name);
        }
        throw new IllegalArgumentException("존재하지 않는 참여자의 이름입니다. (입력된 이름 : " + name + ")");
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
