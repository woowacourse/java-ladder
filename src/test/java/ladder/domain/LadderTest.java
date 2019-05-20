package ladder.domain;

import org.junit.Test;

public class LadderTest {

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
