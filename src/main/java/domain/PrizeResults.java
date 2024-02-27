package domain;

import java.util.HashMap;
import java.util.Map;

public class PrizeResults {
    private final Map<Player, Prize> results;

    private PrizeResults(Map<Player, Prize> results) {
        this.results = results;
    }

    public static PrizeResults of(Players players, Prizes prizes) {
        Map<Player, Prize> results = new HashMap<>();
        return new PrizeResults(results);
    }
}
