package domain;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;
import exception.PlayerCountSameProductException;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Products products;
    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Products products, Ladder ladder) {
        checkLadderGame(players, products);
        this.players = players;
        this.products = products;
        this.ladder = ladder;
    }

    public LadderGameResult gameResult() {
        Map<Player, Product> result = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            result.put(player, products.productOfIndex(climbLadder(player)));
        }
        return new LadderGameResult(Map.copyOf(result));
    }

    private int climbLadder(Player player) {
        for (Line line : ladder.getLines()) {
            climbTheLadderPlayerPosition(player, line);
        }
        return player.getPosition();
    }

    private void climbTheLadderPlayerPosition(Player player, Line line) {
        player.move(line.getDirection(player));
    }

    private void checkLadderGame(Players players, Products products) {
        if (players.getPlayersCount() != products.productsCount()) {
            throw new PlayerCountSameProductException();
        }
    }
}
