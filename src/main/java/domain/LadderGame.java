package domain;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    public static final String PLAYER_COUNT_SAME_PRODUCT = "[ERROR] 상품의 개수와 플레이어의 수가 일치하지 않습니다.";
    Products products;
    Players players;
    Ladder ladder;

    public LadderGame(Players players, Products products, Ladder ladder) {
        checkLadderGame(players, products);
        this.players = players;
        this.products = products;
        this.ladder = ladder;
    }

    public Map<Player, Product> play() {
        Map<Player, Product> result = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            result.put(player, products.productOfIndex(oneClimbTheLadder(player, ladder)));
        }
        return result;
    }

    public int oneClimbTheLadder(Player player, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            climbTheLadderPlayerPosition(player, line);
        }
        return player.getPosition();
    }

    public void climbTheLadderPlayerPosition(Player player, Line line) {
        if (line.getDirection(player) == Direction.LEFT) {
            player.left();
            return;
        }
        if (line.getDirection(player) == Direction.RIGHT) {
            player.right();
        }
    }

    private void checkLadderGame(Players players, Products products) {
        if (players.getPlayersCount() != products.productsCount()) {
            throw new IllegalArgumentException(PLAYER_COUNT_SAME_PRODUCT);
        }
    }
}
