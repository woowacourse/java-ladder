package ladder.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderLineTest {

    public static LadderLine line(int position) {
        if (position == 1) {
            return new LadderLine(Direction.RIGHT);
        }
        if (position == 0) {
            return new LadderLine(Direction.SKIP);
        }
        if (position == -1) {
            return new LadderLine(Direction.LEFT);
        }
        throw new IllegalArgumentException();
    }


    @Test
    public void 라인_생성() {
        LadderLine ladderLine = line(1);
        assertEquals(Direction.RIGHT, ladderLine.direction());
    }

    @Test
    public void 라인_생성2() {
        LadderLine ladderLine = line(1);
        assertEquals(Direction.RIGHT.number(), ladderLine.position());
    }


}