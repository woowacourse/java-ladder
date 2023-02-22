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
        checkLadderGame(players, products);
        this.height = height;
        this.players = players;
        this.products = products;
        this.ladder = ladder;
    }

    public Map<Player, Product> play() {
        Map<Player, Product> result = new HashMap<>();
        for (int index = 0; index < players.getPlayersCount(); index++) {
            result.put(players.getPlayers().get(index), products.getProducts().get(oneClimbTheLadder(index)));
        }
        return result;
    }

    public int oneClimbTheLadder(int playerPosition) {
        int floor = 0;
        int position = playerPosition;
        while (height.isSameHeight(floor)) {
            position = climbTheLadderPlayerPosition(position,floor);
            floor++;
        }
        return playerPosition;
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

    private void checkLadderGame(Players players, Products products) {
        if (players.getPlayersCount() != products.productsCount()) {
            throw new IllegalArgumentException();
        }
    }
}
