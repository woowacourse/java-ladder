package domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void createLadder() {
        assertThatCode(() -> new Ladder(3, 2))
                .doesNotThrowAnyException();
    }
}
