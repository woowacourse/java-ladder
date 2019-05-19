package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 게임이_올바르게_진행되는지_테스트() {
        Players players = new Players(Arrays.asList("pobi", "cu"));
        Rewards rewards = new Rewards(Arrays.asList("1000", "100"));
        LadderGame ladderGame = new LadderGame(2, 5, new AlwaysCreateRule());

        LadderGameResult ladderGameResult = ladderGame.startGame(players, rewards);

        assertThat(ladderGameResult.result("pobi").getName()).isEqualTo("100");
        assertThat(ladderGameResult.result("cu").getName()).isEqualTo("1000");
    }
}