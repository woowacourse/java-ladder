package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFormatTest {
    @Test
    @DisplayName("Boolean 값에 맞는 사다리 포맷을 반환한다.")
    void getComponent() {
        assertThat(LadderFormat.getComponent(Boolean.TRUE))
            .isEqualTo("-");

        assertThat(LadderFormat.getComponent(Boolean.FALSE))
            .isEqualTo(" ");
    }
}
