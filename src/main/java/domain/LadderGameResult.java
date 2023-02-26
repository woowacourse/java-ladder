package domain;

import domain.player.Player;
import domain.product.Product;

import java.util.Collections;
import java.util.Map;

public class LadderGameResult {
    private final Map<Player, Product> ladderResult;

    public LadderGameResult(Map<Player, Product> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Map<Player, Product> getLadderResult() {
        return Collections.unmodifiableMap(ladderResult);
    }
}
