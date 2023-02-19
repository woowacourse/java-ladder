package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepPointTest {

    @Test
    @DisplayName("같은 라인의 두 좌표값에 모두 디딤대가 존재하면 연속된 것이다.")
    void should_BeContinuous_When_TwoConsecutiveStepPointsExist() {
        StepPoint firstStepPoint = StepPoint.EXIST;
        StepPoint secondStepPoint = StepPoint.EXIST;

        assertThat(firstStepPoint.isContinuous(secondStepPoint)).isTrue();
    }
}
