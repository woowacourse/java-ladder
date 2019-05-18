package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    @Test
    public void 전체_사다리_만들기() {

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder().make(randomGenerator, 5, 2);

        LadderRow ladderRow = new LadderRow(Arrays.asList(0, 0, 0, 0, 0));
        assertEquals(ladderRow.status(), ladder.rows(0).status());
    }

    @Test
    public void 전체_사다리_만들기2() {

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder().make(randomGenerator, 5, 2);

        LadderRow ladderRow = new LadderRow(Arrays.asList(1, -1, 1, -1, 0));
        assertEquals(ladderRow.status(), ladder.rows(1).status());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리_만들기_예외() {
        Ladder ladder = new Ladder().init(1, "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리_만들기_예외2() {
        Ladder ladder = new Ladder().init(3, "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리_만들기_예외3() {
        Ladder ladder = new Ladder().init(-1, "-5");
    }
}
