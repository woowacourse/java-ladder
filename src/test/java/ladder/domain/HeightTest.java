package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @Test
    @DisplayName("사다리 높이가 음수이면 예외를 던진다")
    void height_throwException_if_negative() {
        // expected
        assertThatThrownBy(() -> new Height(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("사다리 높이가 1 이하이면 예외를 던진다")
    void height_throwException_if_under2(int input) {
        // expected
        assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
