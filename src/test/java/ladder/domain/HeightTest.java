package ladder.domain;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("사다리 높이가 1 이하이면 예외를 던진다")
    void height_throwException_if_under2(int input) {
        // expected
        assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 2 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    @DisplayName("높이가 2이상인 사다리 높이는 정상적으로 생성된다.")
    void height_generate_when_over2(int input) {
        assertDoesNotThrow(() -> new Height(input));
    }
}
