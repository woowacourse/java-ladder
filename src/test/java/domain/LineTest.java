package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.generator.BooleanGenerator;
import domain.generator.RandomBooleanGenerator;
import domain.generator.TrueBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LineTest {
    private final BooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
    private final BooleanGenerator trueBooleanGenerator = new TrueBooleanGenerator();
    private Line nonRandomLine = new Line(3, trueBooleanGenerator);

    @Nested
    @DisplayName("사다리 발판 생성 테스트")
    class createLadderStepsTest {
        @Test
        void createRandomLadderStepsTest() {
            assertDoesNotThrow(() -> new Line(3, randomBooleanGenerator));
        }

        @Test
        void createNonRandomLadderStepsTest() {
            Assertions.assertThat(nonRandomLine.getLadderSteps())
                    .containsExactly(LadderStep.EXISTS, LadderStep.NONE, LadderStep.EXISTS);
        }
    }

    @Test
    void 사다리를_타고_한칸_이동한다() {
        assertEquals(nonRandomLine.getNextStep(0), 1);
        assertEquals(nonRandomLine.getNextStep(1), 0);
        assertEquals(nonRandomLine.getNextStep(2), 3);
        assertEquals(nonRandomLine.getNextStep(3), 2);
    }
}
