package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderTest {
    @Test
    public void 전체_사다리_만들기() {

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder().make(randomGenerator, 5, 2);

        LadderRow ladderRow = new LadderRow(Arrays.asList(line(0), line(0), line(0), line(0), line(0)));
        assertEquals(ladderRow.status(), ladder.rows(0).status());
    }

    public LadderLine line(int position) {
        if (position == 1) {
            return new LadderLine(LadderRules.RIGHT);
        }
        if (position == 0) {
            return new LadderLine(LadderRules.SKIP);
        }
        if (position == -1) {
            return new LadderLine(LadderRules.LEFT);
        }
        throw new IllegalArgumentException();
    }

    @Test
    public void 전체_사다리_만들기2() {

        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 1, 1, 0));
        Ladder ladder = new Ladder().make(randomGenerator, 5, 2);

        LadderRow ladderRow = new LadderRow(Arrays.asList(line(1), line(-1), line(1), line(-1), line(0)));
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
