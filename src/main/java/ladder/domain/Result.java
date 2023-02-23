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
        validate(key);
        return value.get(key);
    }

    private void validate(final String key) {
        if (!value.containsKey(key)) {
            throw new IllegalArgumentException("결과를 확인할 수 없는 대상입니다. 존재하는 대상 :" + value.keySet());
        }
    }

    public boolean exist(final String key) {
        return value.containsKey(key);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(value);
    }
}
