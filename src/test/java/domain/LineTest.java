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

    @Nested
    @DisplayName("사다리 발판 조회 테스트")
    class queryLadderStepsTest {
        @Test
        void queryLadderStepByIndex() {
            Assertions.assertThat(nonRandomLine.getLadderStep(0)).isEqualTo(LadderStep.EXISTS);
            Assertions.assertThat(nonRandomLine.getLadderStep(1)).isEqualTo(LadderStep.NONE);
            Assertions.assertThat(nonRandomLine.getLadderStep(2)).isEqualTo(LadderStep.EXISTS);
        }
    }
}
