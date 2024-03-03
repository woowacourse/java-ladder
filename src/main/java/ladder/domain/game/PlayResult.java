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

    public PlayResult() {
        this(Collections.emptyMap());
    }

    public void recordResult(final List<Player> players, final List<String> prizes) {
        for (final Player player : players) {
            final int position = player.getPosition();
            result.put(player.getName(), prizes.get(position));
        }
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
