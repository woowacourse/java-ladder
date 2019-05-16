package ladder.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderRowTest {
    LadderRow ladderRow;

    @Before
    public void setLadderRow() {
        ladderRow = new LadderRow(5);
    }


    @Test
    public void 사다리_한줄_생성() {
        ladderRow.draw(true);
        ladderRow.draw(false);
        ladderRow.draw(true);

        assertEquals(Arrays.asList(1, -1, 0, 1, -1), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_생성2() {
        ladderRow.draw(false);
        ladderRow.draw(true);
        ladderRow.draw(false);
        ladderRow.draw(false);

        assertEquals(Arrays.asList(0, 1, -1, 0, 0), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_생성3() {
        ladderRow.draw(true);
        ladderRow.draw(true);
        ladderRow.draw(false);

        assertEquals(Arrays.asList(1, -1, 1, -1, 0), ladderRow.status());
    }


    @Test
    public void 사다리_한줄_긋기_1칸남음() {
        LadderRow ladderRow = new LadderRow(1);

        ByteArrayInputStream input = new ByteArrayInputStream("1 1".getBytes());
        System.setIn(input);

        ladderRow.makeRow();

        assertEquals(Arrays.asList(0), ladderRow.status());
    }

    @Test
    public void 사다리_만들기_테스트() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 1));
        ladderRow.setRandomGenerator(randomGenerator);
        ladderRow.makeRow();
        assertEquals(Arrays.asList(1, -1, 1, -1, 0), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_만들기_테스트() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(0, 0, 0, 0, 0));
        ladderRow.setRandomGenerator(randomGenerator);
        ladderRow.makeRow();
        assertEquals(Arrays.asList(0, 0, 0, 0, 0), ladderRow.status());
    }

    @Test
    public void 사다리_한줄_만들기_테스트2() {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0));
        ladderRow.setRandomGenerator(randomGenerator);
        ladderRow.makeRow();
        assertEquals(Arrays.asList(1, -1, 1, -1, 0), ladderRow.status());
    }

    @After
    public void flushSTDIN() {
        System.setIn(System.in);
    }
}
