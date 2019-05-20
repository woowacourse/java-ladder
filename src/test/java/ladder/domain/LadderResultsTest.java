package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderResultsTest {
    LadderResults ladderResults;

    @Before
    public void setUp() throws Exception {
        Players players = new Players("a,b,c,d,e");
        LadderRewards rewards = new LadderRewards("1,2,3,4,5", 5);
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 1, 1));
        Ladder ladder = new Ladder().make(randomGenerator, 5, 2);
        ladderResults = LadderResultGenerator.result(ladder, players, rewards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과_확인() {
        ladderResults.result("z");
    }

    @Test
    public void 결과_확인2() {
        assertEquals("a : 3\n", ladderResults.result("a"));
    }

    @Test
    public void 결과_확인3() {
        assertEquals("b : 1\n", ladderResults.result("b"));
    }
}