package domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerResults {

    public static final String UNKNOWN_NAME = "존재하지 않는 참가자 이름입니다.";
    private final HashMap<Name, Result> playerResults;

    private PlayerResults(final HashMap<Name, Result> playerResults) {
        this.playerResults = playerResults;
    }

    public static PlayerResults of(Names names, Ladder ladder, Results results) {
        HashMap<Name, Result> playerResults = new HashMap<>();
        for (int from = 0; from < names.count(); from++) {
            int to = ladder.climb(from);
            playerResults.put(names.getValues().get(from), results.getValues().get(to));
        }

        return new PlayerResults(playerResults);
    }

    public Result findResult(final String name) {
        return playerResults.entrySet().stream()
                .filter(entry -> entry.getKey().getValue().equals(name))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_NAME));
    }
}
