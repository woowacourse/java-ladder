package ladder.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderResultTest {
    private LadderResult ladderResult;
    private Ladder ladder;
    private Players players;

    @Before
    public void setLadderGame() {
        LadderRewards ladderRewards = new LadderRewards("꽝,5000,꽝,3000", 4);
        ladderResult = new LadderResult(ladderRewards);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder = new Ladder().make(randomGenerator, 4, 2);
        players = new Players("a,b,c,d");
    }

    @Test
    public void 결과_확인() {
        PlayerResult playerResult = new PlayerResult("a", "꽝");
        assertEquals(playerResult, ladderResult.result(ladder, players.player("a")));
    }

    @Test
    public void 결과_확인2() {
        PlayerResult playerResult = new PlayerResult("b", "꽝");
        assertEquals(playerResult, ladderResult.result(ladder, players.player("b")));
    }

    @Test
    public void 결과_확인3() {
        PlayerResult playerResult = new PlayerResult("c", "3000");
        assertEquals(playerResult, ladderResult.result(ladder, players.player("c")));
    }

    @Test
    public void 결과_확인4() {
        PlayerResult playerResult = new PlayerResult("d", "5000");
        assertEquals(playerResult, ladderResult.result(ladder, players.player("d")));
    }

    @Test
    public void 전체_결과_확인() {

        List<PlayerResult> expect = Arrays.asList(
                new PlayerResult("a", "꽝"),
                new PlayerResult("b", "꽝"),
                new PlayerResult("c", "3000"),
                new PlayerResult("d", "5000"));
        assertEquals(expect, ladderResult.result(ladder, players));
    }
}
