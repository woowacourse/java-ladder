package ladder.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderResultGeneratorTest {
    Ladder ladder;

    @Before
    public void setUp() throws Exception {
        List<LadderRow> rows = new ArrayList<>();

        rows.add(LadderRowGenerator.row(Arrays.asList(LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(1), LadderLineTest.line(-1),
                LadderLineTest.line(0))));

        rows.add(LadderRowGenerator.row(Arrays.asList(LadderLineTest.line(0),
                LadderLineTest.line(0), LadderLineTest.line(0),
                LadderLineTest.line(0), LadderLineTest.line(0))));
        ladder = new Ladder(rows);
    }

    @Test
    public void 결과_확인() {
        assertEquals(1, LadderResultGenerator.find(ladder, 0));
    }

    @Test
    public void 결과_확인2() {
        assertEquals(0, LadderResultGenerator.find(ladder, 1));
    }
}
