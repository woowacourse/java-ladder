package ladder.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.IntStream;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Product;
import ladder.domain.product.Products;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Products products;

    public LadderGame(Ladder ladder, Players players, Products products) {
        // TODO 사다리 크기와 플레이어 수, 상품 수 검증
        this.ladder = ladder;
        this.players = players;
        this.products = products;
    }

    public LadderGameResult progress() {
        Map<Player, Product> results = IntStream.range(0, players.size())
                .boxed()
                .collect(toMap(
                        players::get,
                        this::findResultProduct
                ));
        return new LadderGameResult(results);
    }

    private Product findResultProduct(int playerPosition) {
        int productPosition = ladder.findResultPosition(playerPosition);
        return products.get(productPosition);
    }
}
