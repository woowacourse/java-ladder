package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    Products products;
    Players players;
    Ladder ladder;
    Height height;

    public LadderGame(Players players, Products products, Ladder ladder, Height height) {
        this.height = height;
        this.players = players;
        this.products = products;
        this.ladder = ladder;
    }

    public int climbTheLadderPlayerPosition(int playerPosition,int floor) {
        if (playerPosition == 0) {
            return ladder.sideDecideWhereToGo(playerPosition, floor);
        }
        if (playerPosition == players.getPlayersCount() - 1) {
            return ladder.sideDecideWhereToGo(playerPosition,floor);
        }
        return ladder.decideWhereToGo(playerPosition, floor);
    }

}
