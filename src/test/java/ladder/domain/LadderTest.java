package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    @Test
    public void 전체_사다리_만들기() {
        Ladder ladder = new Ladder(5, 2);

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        ladder.row(randomGenerator);

        LadderRow ladderRow = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        assertEquals(ladderRow.status(), ladder.status(0).status());
    }

    @Test
    public void 전체_사다리_만들기2() {
        Ladder ladder = new Ladder(5, 2);

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 1, 1, 0));
        ladder.row(randomGenerator);

        LadderRow ladderRow = new LadderRow(Arrays.asList(1, -1, 1, -1, 0));
        assertEquals(ladderRow.status(), ladder.status(1).status());
    }
}
