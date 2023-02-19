package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderStepTest {
    @Test
    @DisplayName("사다리 발판 모양을 생성 기능 테스트")
    void createLadderStepTest() {
        assertThat(LadderStep.FIRST_STEP.getStep()).isEqualTo(String.format("%5s", "    |"));
        assertThat(LadderStep.EMPTY_STEP.getStep()).isEqualTo(String.format("%6s", "     |"));
        assertThat(LadderStep.EXIST_STEP.getStep()).isEqualTo(String.format("%6s", "-----|"));
    }
}
