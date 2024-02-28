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
        validate(ladder, players, products);
        this.ladder = ladder;
        this.players = players;
        this.products = products;
    }

    private void validate(Ladder ladder, Players players, Products products) {
        if (ladder.getWidth() + 1 != players.size()) {
            throw new IllegalArgumentException("플레이어 수와 사다리 길이가 일치하지 않습니다.");
        }
        if (ladder.getWidth() + 1 != products.size()) {
            throw new IllegalArgumentException("상품 수와 사다리 길이가 일치하지 않습니다.");
        }
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
