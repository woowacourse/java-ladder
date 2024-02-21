package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("생성 테스트")
    @Test
    void createLadder() {
        assertThatCode(() -> new Ladder(3, 2))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리의 높이는 1 이상만 허용한다.")
    @Test
    void checkLadderHeight() {
        assertThatThrownBy(() -> new Ladder(0, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
