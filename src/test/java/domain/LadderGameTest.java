package domain;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void createLadderGame() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝")));
        Players players = new Players(List.of(new Player("a"), new Player("b")));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        assertDoesNotThrow(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder);
        });
    }
}