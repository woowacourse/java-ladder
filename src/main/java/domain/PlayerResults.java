package domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerResults {

    public static final String UNKNOWN_NAME = "존재하지 않는 참가자 이름입니다.";
    private final HashMap<Name, Result> playerResults;

    public PlayerResults(final HashMap<Name, Result> playerResults) {
        this.playerResults = new HashMap<>(playerResults);
    }

    public Result findResult(final String name) {
        return playerResults.entrySet().stream()
                .filter(entry -> entry.getKey().getValue().equals(name))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_NAME));
    }
}
