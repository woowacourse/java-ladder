package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameResultTest {
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        Map<Player, Reward> result = new HashMap<>();
        result.put(new Player("pobi"), new Reward("1000"));
        result.put(new Player("cu"), new Reward("100"));
        ladderGameResult = new LadderGameResult(result);
    }

    @Test
    void 이름으로_결과를_제대로_찾는지_확인() {
        assertThat(ladderGameResult.result("pobi").getName()).isEqualTo("1000");
    }

    @Test
    void 참가자가_존재하지_않는_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            ladderGameResult.result("jason");
        });
    }
}