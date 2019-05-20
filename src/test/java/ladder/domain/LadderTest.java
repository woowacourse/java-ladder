package ladder.domain;

import ladder.util.RowInputGenerator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    @Test
    public void 전체_사다리_만들기() {
        RowInputGenerator rowInputGenerator = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder(5, 2, rowInputGenerator);
        LadderRow ladderRow = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        assertEquals(ladderRow.status(), ladder.status(0).status());
    }

    @Test
    public void 전체_사다리_만들기2() {
        RowInputGenerator rowInputGenerator = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder(5, 2, rowInputGenerator);
        LadderRow ladderRow = new LadderRow(Arrays.asList(1, -1, 1, -1, 0));
        assertEquals(ladderRow.status(), ladder.status(1).status());
    }
}
