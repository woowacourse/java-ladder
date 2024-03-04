package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepTest {

    @DisplayName("스텝의 상태를 True로 변경하는 테스트")
    @Test
    void changeStatusTest() {
        Step step = new Step();

        step.build();

        assertThat(step.getBuildStatus()).isTrue();
    }
}
