package ladder.domain;

import java.util.Map;
import ladder.domain.player.Player;
import ladder.domain.product.Product;

public class LadderGameResult {

    private final Map<Player, Product> results;

    public LadderGameResult(Map<Player, Product> results) {
        this.results = results;
    }

    public Product findResult(Player player) {
        Product result = results.get(player);

        if (result == null) {
            throw new IllegalArgumentException("해당 플레이어는 게임에 참여하지 않았습니다");
        }
        return result;
    }
}
