package domain;

import java.util.HashMap;

public class PlayerResults {

    private final HashMap<Name, Result> playerResults;

    public PlayerResults(final HashMap<Name, Result> playerResults) {
        this.playerResults = new HashMap<>(playerResults);
    }
}
