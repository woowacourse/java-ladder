package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Players;
import domain.product.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TrueOrFalseGenerator;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderGameTest {

    LadderGame ladderGame;

    @Test
    @BeforeEach
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void setUpLadderGame() {
        Generator generator = new Generator();
        Height height = new Height(1);
        Products products = Products.generate(List.of("사과", "꽝", "1000"));
        Players players = Players.generate(List.of("a", "b", "c"));
        Ladder ladder = Ladder.generate(players, height, generator);
        ladderGame = new LadderGame(players, products, ladder);
    }

    @Test
    @DisplayName("사다리 게임의 필요한 객체 저장")
    void createLadderGame() {
        Generator generator = new Generator();
        Products products = Products.generate(List.of("사과", "꽝"));
        Height height = new Height(1);
        Players players = Players.generate(List.of("a", "b", "c"));
        Ladder ladder = Ladder.generate(players, height, generator);
        assertDoesNotThrow(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder);
        });
    }

    @Test
    @DisplayName("선물의 개수와 플레이어의 수가 같지 않을때 에외")
    void createLadderGame1() {
        Generator generator = new Generator();
        Products products = Products.generate(List.of("사과", "꽝", "1000"));
        Height height = new Height(1);
        Players players = Players.generate(List.of("a", "b", "c"));
        Ladder ladder = Ladder.generate(players, height, generator);
        assertThatThrownBy(() -> {
            LadderGame ladderGame = new LadderGame(players, products, ladder);
        });
    }

    class Generator implements TrueOrFalseGenerator {

        @Override
        public boolean generate() {
            return false;
        }
    }
}


