package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 게임_결과가_올바른지_테스트() {
        Ladder ladder = LadderGenerator.generateLadder(5, 2, new AlwaysCreateRule());
        Tags members = new Tags(Arrays.asList("pobi", "cu"));
        Tags prizes = new Tags(Arrays.asList("1000", "100"));
        LadderGameResult result = LadderGame.startGame(members, ladder, prizes);

        assertThat(result.prize("pobi")).isEqualTo("100");
        assertThat(result.prize("cu")).isEqualTo("1000");
    }
}