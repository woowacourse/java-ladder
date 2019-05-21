package ladder.domain;

import ladder.util.RowInputGenerator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    @Test
    public void 전체_사다리_만들기() {
        RowInputGenerator rowInputGeneratorLadder = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder(5, new Height("2"), rowInputGeneratorLadder);
        RowInputGenerator rowInputGeneratorRow = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 0));
        LadderRow ladderRow = new LadderRow(5, rowInputGeneratorRow);
        ladderRow.makeRow();
        assertEquals(ladderRow.status(), ladder.status(0).status());
    }

    @Test
    public void 전체_사다리_만들기2() {
        RowInputGenerator rowInputGeneratorLadder = new RowInputGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder(5, new Height("2"), rowInputGeneratorLadder);
        RowInputGenerator rowInputGeneratorRow = new RowInputGenerator(Arrays.asList(0, 1, 1));
        LadderRow ladderRow = new LadderRow(5, rowInputGeneratorRow);
        ladderRow.makeRow();
        assertEquals(ladderRow.status(), ladder.status(1).status());
    }
}
