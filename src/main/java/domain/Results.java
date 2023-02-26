package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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


    public Set<Player> getPlayers() {
        return results.keySet();
    }

    public Prize getPrizeByPlayer(Player player) {
        return results.get(player);
    }

    public Map<Player, Prize> getResults() {
        return results;
    }

}
