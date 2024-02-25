package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateTest_WhenHeightIsNotPositive(int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상이어야 합니다.");
    }
}
