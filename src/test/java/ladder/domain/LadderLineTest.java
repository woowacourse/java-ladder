package ladder.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderLineTest {

    public static LadderLine line(int position) {
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
    public void 라인_생성() {
        LadderLine ladderLine = line(1);
        assertEquals(LadderRules.RIGHT, ladderLine.direction());
    }

    @Test
    public void 라인_생성2() {
        LadderLine ladderLine = line(1);
        assertEquals(LadderRules.RIGHT.number(), ladderLine.position());
    }


}