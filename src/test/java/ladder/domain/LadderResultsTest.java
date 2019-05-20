package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderResultsTest {
    LadderResults ladderResults;

    @Before
    public void setUp() throws Exception {
        Players players = new Players("a,b,c,d,e");
        LadderRewards rewards = new LadderRewards("1,2,3,4,5", 5);
        List<LadderRow> rows = new ArrayList<>();

        rows.add(LadderRowGenerator.row(Arrays.asList(LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(1), LadderLineTest.line(-1),
                LadderLineTest.line(0))));

        rows.add(LadderRowGenerator.row(Arrays.asList(LadderLineTest.line(0),
                LadderLineTest.line(1), LadderLineTest.line(-1),
                LadderLineTest.line(1), LadderLineTest.line(-1))));
        Ladder ladder = new Ladder(rows);

        ladderResults = LadderResultGenerator.result(ladder, players, rewards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과_확인() {
        ladderResults.result("z");
    }

    @Test
    public void 결과_확인2() {
        assertEquals("3", ladderResults.result("a"));
    }

    @Test
    public void 결과_확인3() {
        assertEquals("1", ladderResults.result("b"));
    }
}