package domain;

import java.util.HashMap;
import java.util.Map;

public class Results {

    private final Map<Player, Prize> results;

    public Results() {
        results = new HashMap<>();
    }

    public void addResult(Player player, Prize prize) {
        results.put(player, prize);
    }

    public boolean isSameSizeTo(int size) {
        return results.size() == size;
    }

    public Map<Player, Prize> getResults() {
        return results;
    }
}
