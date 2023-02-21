package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @Nested
    @DisplayName("사다리 발판 생성 테스트")
    class createLadderStepsTest {
        @Test
        void createRandomLadderStepsTest() {
            assertDoesNotThrow(() -> new Line(3, randomBooleanGenerator));
        }

        @Test
        void createNonRandomLadderStepsTest() {
            Line line = new Line(3, trueBooleanGenerator);
            Assertions.assertThat(line.getLadderSteps())
                    .containsExactly(LadderStep.EXISTS, LadderStep.NONE, LadderStep.EXISTS);
        }
    }
}
