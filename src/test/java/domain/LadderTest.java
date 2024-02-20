package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 11})
    @DisplayName("사다리 높이 검증")
    void validateLadderHeight(int height) {
        assertThatThrownBy(() -> new Ladder(height))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사다리 높이는 5이상 10 이하여야 합니다.");
    }
}