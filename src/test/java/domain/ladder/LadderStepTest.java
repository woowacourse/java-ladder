package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.generator.LadderStepGenerator;
import domain.generator.NoneLadderStepGenerator;
import domain.generator.ExistsLadderStepGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LadderStepTest {

    private final LadderStepGenerator existsGenerator = new ExistsLadderStepGenerator();
    private final LadderStepGenerator noneGenerator = new NoneLadderStepGenerator();

    @DisplayName("첫 번째 사다리 발판을 생성할 때는 제약 없이 생성한다.")
    @Test
    void createFreelyTest() {
        Assertions.assertThat(LadderStep.createFreely(existsGenerator)).isEqualTo(LadderStep.EXISTS);
        assertThat(LadderStep.createFreely(noneGenerator)).isEqualTo(LadderStep.NONE);
    }

    @DisplayName("연속해서 사다리 발판이 존재할 수 없다.")
    @Nested
    class createConsideringPreviousStepTest {

        @DisplayName("직전 사다리가 존재하는 경우, 사다리 발판을 생성하지 않는다.")
        @Test
        void previousStepExistsTest() {
            assertAll(
                    () -> assertThat(LadderStep.createConsideringPreviousStep(existsGenerator, LadderStep.EXISTS))
                            .isEqualTo(LadderStep.NONE),
                    () -> assertThat(LadderStep.createConsideringPreviousStep(noneGenerator, LadderStep.EXISTS))
                            .isEqualTo(LadderStep.NONE)
            );
        }

        @DisplayName("직전 사다리가 존재하지 않는 경우, 사다리 발판을 자유롭게 생성할 수 있다.")
        @Test
        void previousStepNoneTest() {
            assertThat(LadderStep.createConsideringPreviousStep(existsGenerator, LadderStep.NONE))
                    .isEqualTo(LadderStep.EXISTS);
            assertThat(LadderStep.createConsideringPreviousStep(noneGenerator, LadderStep.NONE))
                    .isEqualTo(LadderStep.NONE);
        }
    }

    @DisplayName("사다리의 발판이 존재하는 지 확인 후 반환할 수 있다.")
    @Test
    void returnExistsTest() {
        assertTrue(LadderStep.EXISTS.exists());
        assertFalse(LadderStep.NONE.exists());
    }
}
