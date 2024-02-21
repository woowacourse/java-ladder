package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {Height.MIN - 1, Height.MAX + 1})
    @DisplayName("높이 검증")
    void validateHeight(int length) {
        assertThatThrownBy(() -> new Height(length))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.HEIGHT_RANGE.getMessage());
    }
}