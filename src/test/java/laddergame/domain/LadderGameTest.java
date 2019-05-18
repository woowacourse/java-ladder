package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 게임이_올바르게_진행되는지_테스트() {
        List<String> playerNames = Arrays.asList("pobi", "cu");
        List<String> rewardNames = Arrays.asList("1000", "100");
        LadderGame ladderGame = new LadderGame(playerNames, rewardNames, 5, new AlwaysCreateRule());

        assertThat(ladderGame.startGame().result("pobi").getName()).isEqualTo("100");
        assertThat(ladderGame.startGame().result("cu").getName()).isEqualTo("1000");
    }
}