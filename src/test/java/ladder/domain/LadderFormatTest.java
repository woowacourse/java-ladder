package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFormatTest {

    @DisplayName("Boolean 값에 맞는 사다리 포맷을 반환한다.")
    @Test
    void getComponent() {
        Assertions.assertThat(LadderFormat.getComponent(Boolean.TRUE))
            .isEqualTo("-");

        Assertions.assertThat(LadderFormat.getComponent(Boolean.FALSE))
            .isEqualTo(" ");
    }
}
