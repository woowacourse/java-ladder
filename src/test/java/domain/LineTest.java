package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.booleanGenerator.BooleanGenerator;
import utils.booleanGenerator.RandomBooleanGenerator;

class LineTest {
    private final BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

    @Nested
    class pointsTest {
        @DisplayName("연속 true를 테스트한다.")
        @Test
        void trueSequenceTest() {
            assertDoesNotThrow(() -> new Line(3, randomBooleanGenerator));
        }
    }
}
