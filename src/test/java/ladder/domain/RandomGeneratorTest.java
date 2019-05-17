package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {
    @Test
    void 이전_값이_True인_경우_False_반환() {
        assertFalse(RandomGenerator.getNextValue(true));
    }

    @Test
    void 이전_값이_False인_경우_랜덤_반환() {
        List<Boolean> booleans = new ArrayList<>();

        for (int i = 0; i < 100; ++i) {
            booleans.add(RandomGenerator.getNextValue(false));
        }

        assertTrue((booleans.contains(true)) && (booleans.contains(false)));
    }
}
