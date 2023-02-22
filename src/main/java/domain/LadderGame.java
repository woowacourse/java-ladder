package domain;

import domain.ladder.Ladder;
import domain.player.Players;
import domain.product.Products;

public class LadderGame {
    Products products;
    Players players;
    Ladder ladder;

    public LadderGame(Players players, Products products, Ladder ladder) {
        this.players = players;
        this.products = products;
        this.ladder = ladder;
    }
}
