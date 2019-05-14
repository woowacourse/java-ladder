package ladder.domain;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class LadderRowTest {
    @Test
    public void 사다리_한줄_생성() {
        LadderRow ladderRow = new LadderRow(5);
        ladderRow.draw();
        ladderRow.skip();
        ladderRow.draw();

        assertEquals(Arrays.asList(1, -1, 0, 1, -1), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_생성2() {
        LadderRow ladderRow = new LadderRow(4);
        ladderRow.skip();
        ladderRow.draw();
        ladderRow.skip();

        assertEquals(Arrays.asList(0, 1, -1, 0), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_생성3() {
        LadderRow ladderRow = new LadderRow(4);
        ladderRow.draw();
        ladderRow.draw();

        assertEquals(Arrays.asList(1, -1, 1, -1), ladderRow.status());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리_한줄_그리기_불가능() {
        LadderRow ladderRow = new LadderRow(5);
        ladderRow.draw();
        ladderRow.draw();
        ladderRow.draw();
    }
}
