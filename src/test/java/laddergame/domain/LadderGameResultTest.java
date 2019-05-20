package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameResultTest {
    @Test
    void 게임_결과값을_제대로_저장하는지_확인() {
        /* Given */
        Map<Tag, Tag> result = new HashMap<>();
        Tag member1 = new Tag("pobi");
        Tag member2 = new Tag("cu");
        Tag prize1 = new Tag("1000");
        Tag prize2 = new Tag("100");

        /* When */
        result.put(member1, prize1);
        result.put(member2, prize2);
        LadderGameResult ladderGameResult = new LadderGameResult(result);

        /* Then */
        assertThat(ladderGameResult.prize(new Tag("pobi")).getName()).isEqualTo("1000");
        assertThat(ladderGameResult.allPrizes()).isEqualTo(result);
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGameResult.prize(new Tag("gogo"));
        });
    }
}