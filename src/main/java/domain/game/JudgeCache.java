package domain.game;

import domain.player.Player;
import domain.prize.Prize;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JudgeCache {
    private final Map<Player, Prize> cache;

    public JudgeCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void save(final Player player, final Prize prize) {
        cache.put(player, prize);
    }

    public boolean hasPlayer(final Player player) {
        return cache.containsKey(player);
    }

    public Prize find(final Player player) {
        return cache.get(player);
    }
}
