package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 게임_결과가_올바른지_테스트() {
        Ladder ladder = LadderGenerator.generateLadder(5, 2, new AlwaysCreate());
        Members members = new Members(Arrays.asList("pobi", "cu"));
        Prizes prizes = new Prizes(Arrays.asList("1000", "100"));
        Map<String, String> result = LadderGame.startGame(members, ladder, prizes);

        assertThat(result.get("pobi")).isEqualTo("100");
        assertThat(result.get("cu")).isEqualTo("1000");
    }
}