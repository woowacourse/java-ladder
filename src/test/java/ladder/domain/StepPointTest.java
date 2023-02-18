package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StepPointTest {

    @Test
    void 같은_라인의_두_좌표값에_모두_디딤대가_존재하면_연속된_것이다() {
        StepPoint firstStepPoint = StepPoint.EXIST;
        StepPoint secondStepPoint = StepPoint.EXIST;

        assertThat(firstStepPoint.isContinuous(secondStepPoint)).isTrue();
    }
}
