package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("폭 검증")
    void validateWidth(int length) {
        assertThatThrownBy(() -> new Width(length))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.WIDTH_RANGE.getMessage());
    }
}