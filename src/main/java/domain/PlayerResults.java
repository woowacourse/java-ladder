package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerResults {

    public static final String UNKNOWN_NAME = "존재하지 않는 참가자 이름입니다.";
    private final Map<Name, Result> playerResults;

    private PlayerResults(final Map<Name, Result> playerResults) {
        this.playerResults = playerResults;
    }

    public static PlayerResults of(Names names, Ladder ladder, Results results) {
        Map<Name, Result> playerResults = new LinkedHashMap<>();
        for (final Name name : names.getValues()) {
            Position from = new Position(names.findIndexBy(name));
            Position to = ladder.climb(from);
            playerResults.put(name, results.findAtIndex(to.getValue()));
        }

        return new PlayerResults(playerResults);
    }

    public Result findResult(final String target) {
        Name name = playerResults.keySet().stream()
                .filter(key -> key.isSame(target))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_NAME));
        return playerResults.get(name);
    }

    public Map<Name, Result> getPlayerResults() {
        return Collections.unmodifiableMap(playerResults);
    }
}
