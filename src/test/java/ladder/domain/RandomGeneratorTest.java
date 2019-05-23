package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RandomGeneratorTest {
    RandomStepsGenerator stepsGenerator;

    @BeforeEach
    void setUp() {
        stepsGenerator = new RandomStepsGenerator(4);
    }

    @Test
    void 이전_값이_True이면_False_반환() {
        assertFalse(stepsGenerator.getRandomStep(new Step(true)).exist());
    }
}
