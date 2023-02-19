package laddergame.domain;

import laddergame.util.RandomBooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new LadderMaker(new RandomBooleanGenerator()).make(players.size(), new LadderHeight(5));
        ladderGame = new LadderGame(players, ladder);
    }

    @Test
    @DisplayName("사용자들을 잘 가지고 있는지 테스트")
    void getPlayerNamesTest() {
        assertThat(ladderGame.getPlayerNames().equals(List.of("pobi", "honux", "crong", "jk"))).isTrue();
    }

    @Test
    @DisplayName("사용자들을 잘 가지고 있는지 테스트")
    void getLadderTest() {
        assertThat(ladderGame.getLadderMap()).hasSize(5);
    }

}
