package domain;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Point;
import domain.player.Player;
import domain.player.Players;
import domain.product.Product;
import domain.product.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    LadderGame ladderGame;

    @Test
    @BeforeEach
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void setUpLadderGame() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝"), new Product("1000")));
        Players players = new Players(List.of(new Player("a", 0),
                new Player("b", 1), new Player("c", 2)));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        ladderGame = new LadderGame(players, products, ladder);
    }

    @Test
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void createLadderGame() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝")));
        Players players = new Players(List.of(new Player("a", 0), new Player("b", 1)));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        assertDoesNotThrow(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder);
        });
    }

    @Test
    @DisplayName("선물의 개수와 플레이어의 수가 같지 않을때 에외")
    void createLadderGame1() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝"), new Product("100")));
        Players players = new Players(List.of(new Player("a", 0), new Player("b", 1)));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        assertThatThrownBy(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder);
        });
    }

}