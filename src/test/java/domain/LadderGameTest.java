package domain;

import domain.ladder.Height;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    LadderGame ladderGame;

    @Test
    @BeforeEach
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void setUpLadderGame() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝"), new Product("1000")));
        Players players = new Players(List.of(new Player("a"),
                new Player("b"), new Player("c")));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        Height height = new Height(1);
        ladderGame = new LadderGame(players, products, ladder, height);
    }

    @Test
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void createLadderGame() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝")));
        Players players = new Players(List.of(new Player("a"), new Player("b")));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        Height height = new Height(1);
        assertDoesNotThrow(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder, height);
        });
    }

    @Test
    @DisplayName("선물의 개수와 플레이어의 수가 같지 않을때 에외")
    void createLadderGame1() {
        Products products = new Products(List.of(new Product("사과"), new Product("꽝"),new Product("100")));
        Players players = new Players(List.of(new Player("a"), new Player("b")));
        Ladder ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
        Height height = new Height(1);
        assertThatThrownBy(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder, height);
        });
    }

    @Test
    @DisplayName("사다리 좌표의 따른 플레이어 이동")
    void climbTheLadderPlayerPosition() {
        assertThat(ladderGame.climbTheLadderPlayerPosition(0, 0)).isEqualTo(0);
    }
}