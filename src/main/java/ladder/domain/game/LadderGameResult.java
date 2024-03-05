package ladder.domain.game;

import java.util.Map;
import java.util.function.BiConsumer;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

public class LadderGameResult {

    private final Map<Player, Reward> result;

    public LadderGameResult(final Map<Player, Reward> result) {
        this.result = result;
    }

    public boolean contains(final Player player) {
        return result.containsKey(player);
    }

    public Reward rewardOf(final Player player) {
        return result.get(player);
    }

    public void forEach(final BiConsumer<Player, Reward> action) {
        result.forEach(action);
    }
}
