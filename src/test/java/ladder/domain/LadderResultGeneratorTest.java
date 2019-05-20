package ladder.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LadderResultGeneratorTest {
    Ladder ladder;

    @Before
    public void setUp() throws Exception {
        RandomGenerator randomGenerator = new RandomGenerator(Arrays.asList(1, 1, 0, 0, 0, 0, 0, 0));
        ladder = new Ladder().make(randomGenerator, 5, 2);
    }

    @Test
    public void 결과_확인() {
        assertEquals(1, LadderResultGenerator.find(ladder, 0));
    }

    @Test
    public void 결과_확인2() {
        assertEquals(0, LadderResultGenerator.find(ladder, 1));
    }
}
