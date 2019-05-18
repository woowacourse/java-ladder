package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderRowTest {
    LadderRow ladderRow;

    @Before
    public void setLadderRow() {
        ladderRow = new LadderRow();
    }

    @Test
    public void 사다리_한줄_긋기_1칸남음() {

        for (int i = 0; i < 1000; i++) {
            assertEquals(Arrays.asList(LadderLineTest.line(0)), new LadderRow().manual(1, new RandomGenerator()).status());
        }
    }

    @Test
    public void 사다리_만들기_테스트() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 1));
        assertEquals(Arrays.asList(LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(0)),
                ladderRow.manual(5, randomGenerator).status());
    }

    @Test
    public void 사다리_한줄_만들기_테스트() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 0));
        assertEquals(Arrays.asList(LadderLineTest.line(0),
                LadderLineTest.line(0), LadderLineTest.line(0),
                LadderLineTest.line(0), LadderLineTest.line(0)),
                ladderRow.manual(5, randomGenerator).status());
    }

    @Test
    public void 사다리_한줄_만들기_테스트2() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0));
        assertEquals(Arrays.asList(LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(1),
                LadderLineTest.line(-1), LadderLineTest.line(0)),
                ladderRow.manual(5, randomGenerator).status());
    }
}
