package ladder.domain.game;

import java.util.Map;
import java.util.function.BiConsumer;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

public record LadderGameResult(Map<Player, Reward> result) {

    public boolean contains(Player player) {
        return result.containsKey(player);
    }

    public Reward rewardOf(Player player) {
        return result.get(player);
    }

    public void forEach(BiConsumer<Player, Reward> action) {
        result.forEach(action);
    }
}
