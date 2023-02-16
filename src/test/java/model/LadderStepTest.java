package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderStepTest {

    @Test
    @DisplayName("사다리 발판 모양을 생성 기능 테스트")
    void createLadderStepTest() {
        assertThat(LadderStep.of("first")).isEqualTo(LadderStep.FIRST_STEP);
        assertThat(LadderStep.of("empty")).isEqualTo(LadderStep.EMPTY_STEP);
        assertThat(LadderStep.of("exist")).isEqualTo(LadderStep.EXIST_STEP);
    }
}
