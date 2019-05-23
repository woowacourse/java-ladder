package ladder.domain;

import java.util.Map;

public class LadderResult {
    private Map<Player, Item> result;

    public LadderResult(Map<Player, Item> result) {
        this.result = result;
    }

    public Item getItemByPlayer(Player player) {
        return result.get(player);
    }
}
