package ladder.domain;

import java.util.Map;

public class LadderResult {
    private final Map<Player, Item> result;

    public LadderResult(Map<Player, Item> result) {
        this.result = result;
    }

    public Item getItemOfPlayer(Player player) {
        validateNotExistPlayer(player);
        validateNullItem(player);
        return result.get(player);
    }

    private void validateNotExistPlayer(Player player) {
        if(!result.containsKey(player)) {
            throw new IllegalStateException("플레이어가 존재하지 않습니다.");
        }
    }

    private void validateNullItem(Player player) {
        if(result.get(player) == null) {
            throw new IllegalStateException("플레이어의 결과가 존재하지 않습니다.");
        }
    }
}
