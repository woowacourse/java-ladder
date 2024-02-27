package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Product;
import ladder.domain.product.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @DisplayName("사다리 게임의 결과를 반환할 수 있다")
    @Test
    void progressTest() {
        /*
        *   pobi crong    jk
        *      |-----|     |
        *      |-----|     |
        *      |-----|     |
        *   5000     꽝 3000
        * */

        Ladder ladder = Ladder.of(new Height(3), 3, size -> List.of(Stick.EXISTENCE, Stick.NON_EXISTENCE));
        Players players = Players.from(List.of("pobi", "crong", "jk"));
        Products products = Products.from(List.of("5000", "꽝", "3000"));
        LadderGame ladderGame = new LadderGame(ladder, players, products);
        Map<Player, Product> expected = Map.of(new Player("pobi"), new Product("꽝"),
                new Player("crong"), new Product("5000"),
                new Player("jk"), new Product("3000"));

        LadderGameResult actual = ladderGame.progress();

        assertThat(actual.getResults()).isEqualTo(expected);
    }
}
