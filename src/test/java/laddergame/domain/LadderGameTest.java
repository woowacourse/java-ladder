package laddergame.domain;

import laddergame.util.RandomBooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new LadderMaker(new RandomBooleanGenerator()).make(players.size(), new LadderHeight(5));
        Prizes prizes = new Prizes(List.of("꽝", "2000", "꽝", "1000"));
        ladderGame = new LadderGame(players, ladder, prizes);
    }

    @Test
    @DisplayName("사용자들을 잘 가지고 있는지 테스트")
    void getPlayerNamesTest() {
        assertThat(ladderGame.getPlayerNames().equals(List.of("pobi", "honux", "crong", "jk"))).isTrue();
    }

    @Test
    @DisplayName("사다리를 잘 가지고 있는지 테스트")
    void getLadderTest() {
        assertThat(ladderGame.getLadderMap()).hasSize(5);
    }

    @Test
    @DisplayName("사용자와 상품의 수가 다르면 예외 발생")
    void playerPrizeSizeExceptionTest() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new LadderMaker(new RandomBooleanGenerator()).make(players.size(), new LadderHeight(5));
        Prizes prizes = new Prizes(List.of("꽝", "2000", "꽝", "1000", "1000"));

        assertThatThrownBy(() -> new LadderGame(players, ladder, prizes)).isInstanceOf(IllegalArgumentException.class);
    }

}
