package domain.prize;

import domain.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Results {

    private final Map<Player, Prize> results;

    public Results() {
        results = new HashMap<>();
    }

    public void addResult(Player player, Prize prize) {
        results.put(player, prize);
    }

    public boolean isSameSizeAs(int size) {
        return results.size() == size;
    }

    public Set<Player> getPlayers() {
        return results.keySet();
    }

    public Prize getPrizeByPlayer(Player player) {
        return results.get(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
