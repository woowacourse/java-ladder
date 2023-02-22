package domain;

import domain.player.Player;
import domain.product.Product;

import java.util.Map;

public class LadderGameResult {
    Map<Player, Product> ladderResult;
    public LadderGameResult(Map<Player, Product> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public Map<Player, Product> getLadderResult() {
        return ladderResult;
    }



}
