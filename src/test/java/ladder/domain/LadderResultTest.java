package ladder.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderResultTest {
    private LadderRewards ladderRewards;
    private LadderResult ladderResult;
    private Ladder ladder;
    private Players players;
    private RandomGenerator randomGenerator;

    @Before
    public void setLadderGame() {
        ladderRewards = new LadderRewards(Arrays.asList("꽝", "5000", "꽝", "3000"), 4);
        ladderResult = new LadderResult(ladderRewards);
        randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1));
        ladder = new Ladder(4, 2, randomGenerator);
        players = new Players(Arrays.asList("a", "b", "c", "d"));
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

        List<PlayerResult> expect = new ArrayList<>();
        expect.add(new PlayerResult("a", "꽝"));
        expect.add(new PlayerResult("b", "꽝"));
        expect.add(new PlayerResult("c", "3000"));
        expect.add(new PlayerResult("d", "5000"));

        assertEquals(expect, ladderResult.result(ladder, players));
    }
}
