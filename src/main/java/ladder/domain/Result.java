package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<String, String> value;

    public Result(final Map<String, String> value) {
        this.value = value;
    }

    public static Result of(final Players players, final Ladder ladder, final Prizes prizes) {
        final Map<String, String> result = new LinkedHashMap<>();
        final List<String> playerNames = players.getPlayerNames();

        for (int playerPosition = 0; playerPosition < playerNames.size(); playerPosition++) {
            final int prizePosition = ladder.climb(playerPosition);
            result.put(playerNames.get(playerPosition), prizes.check(prizePosition));
        }
        return new Result(result);
    }

    public String extract(final String key) {
        return value.get(key);
    }

    public boolean exist(final String key) {
        return value.containsKey(key);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(value);
    }
}
