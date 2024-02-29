package ladder.domain.game;

import ladder.domain.player.Player;
import ladder.utils.Command;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayResult {
    enum Status {
        EXECUTABLE,
        NON_EXECUTABLE;

        public boolean isExecutable() {
            return this == EXECUTABLE;
        }
    }

    private final Map<String, String> result;
    private Status status;

    PlayResult(final Map<String, String> result) {
        this.result = new LinkedHashMap<>(result);
        this.status = Status.EXECUTABLE;
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

    public boolean canAskResult() {
        return status.isExecutable();
    }

    public boolean hasResultOf(final String name) {
        return isExpressionOfAllPlayer(name) || result.containsKey(name);
    }

    public Map<String, String> checkPlayerResultByName(final String name) {
        if (isExpressionOfAllPlayer(name)) {
            status = Status.NON_EXECUTABLE;
            return result;
        }
        return Map.of(name, result.get(name));
    }

    private boolean isExpressionOfAllPlayer(final String name) {
        return Command.EXPRESSION_OF_ALL_PLAYER.isMatch(name);
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
