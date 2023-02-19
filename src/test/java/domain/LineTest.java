package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import domain.booleanGenerator.BooleanGenerator;
import domain.booleanGenerator.RandomBooleanGenerator;
import domain.booleanGenerator.TrueBooleanGenerator;

class LineTest {
    private final BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
    private final BooleanGenerator trueBooleanGenerator = new TrueBooleanGenerator();

    @Nested
    class pointsTest {
        @DisplayName("연속 true를 테스트한다.")
        @Test
        void trueSequenceTest() {
            assertDoesNotThrow(() -> new Line(3, randomBooleanGenerator));
        }
    }
}
