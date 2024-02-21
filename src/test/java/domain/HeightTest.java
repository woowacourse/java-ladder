package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 11})
    @DisplayName("높이 검증")
    void validateHeight(int length) {
        assertThatThrownBy(() -> new Height(length))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("높이는 5이상 10 이하여야 합니다.");
    }
}