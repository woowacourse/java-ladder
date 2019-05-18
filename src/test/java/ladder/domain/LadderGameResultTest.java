package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {
    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        Map<Player, Reward> resultSample = new HashMap<>();
        resultSample.put(new Player("pobi"), new Reward("100"));
        resultSample.put(new Player("denis"), new Reward("200"));
        resultSample.put(new Player("whale"), new Reward("Bomb!"));
        ladderGameResult = new LadderGameResult(resultSample);
    }

    @Test
    void 이름에_맞는_상품_찾기() {
        assertThat(ladderGameResult.findReward(new Player("pobi"))).isEqualTo(new Reward("100"));
    }
}
