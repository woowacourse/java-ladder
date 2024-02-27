package domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerResults {

    private final HashMap<Name, Result> playerResults;

    public PlayerResults(final HashMap<Name, Result> playerResults) {
        this.playerResults = new HashMap<>(playerResults);
    }

    public Result findResult(final String name) {
        return playerResults.entrySet().stream()
                .filter(entry -> entry.getKey().getValue().equals(name))
                .map(Map.Entry::getValue)
                .findAny()
                .orElseThrow();
    }
}
