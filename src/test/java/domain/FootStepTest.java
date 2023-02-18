package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("디딤대는 ")
class FootStepTest {
    @Test
    @DisplayName("없을 경우 발을 디딜 수 없다고 알려준다.")
    void unsteppableCase() {
        assertThat(FootStep.of(false).isSteppable())
                .isFalse();
    }

    @Test
    @DisplayName("있을 경우 발을 디딜 수 있다고 알려준다.")
    void steppableCase() {
        assertThat(FootStep.of(true).isSteppable())
                .isTrue();
    }
}