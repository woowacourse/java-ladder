package laddergame.domain;

import laddergame.controller.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 게임_결과가_올바른지_테스트() {
        /* Given */
        Tags members = new Tags(Arrays.asList("pobi", "cu"));
        Tags prizes = new Tags(Arrays.asList("1000", "100"));
        LadderGame ladderGame = new LadderGame(members, prizes, new AlwaysCreateRule(), 5);

        /* Then */
        LadderGameResult result = ladderGame.startGame();

        /* When */
        assertThat(result.prize(new Tag("pobi"))).isEqualTo(new Tag("100"));
        assertThat(result.prize(new Tag("cu"))).isEqualTo(new Tag("1000"));
    }
}