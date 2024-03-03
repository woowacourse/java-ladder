package model.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StepStatusTest {
    @DisplayName("동일한 값을 가진 StepStatus 객체여서 참을 반환한다.")
    @Test
    void matchTest() {
        // given
        StepStatus status = StepStatus.from(true);
        StepStatus sameStatus = StepStatus.CONNECTED;
        // when
        boolean matched = status.isMatched(sameStatus);
        // then
        Assertions.assertThat(matched).isEqualTo(true);
    }

    @DisplayName("다른 값을 가진 StepStatus 객체여서 거짓을 반환한다.")
    @Test
    void doesNotMatchTest() {
        // given
        StepStatus status = StepStatus.from(false);
        StepStatus sameStatus = StepStatus.CONNECTED;
        // when
        boolean matched = status.isMatched(sameStatus);
        // then
        Assertions.assertThat(matched).isEqualTo(false);
    }
}
