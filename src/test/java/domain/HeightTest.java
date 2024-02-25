package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 11})
    @DisplayName("부적절한 사다리 높이(5 미만 10 초과)를 입력 받으면 예외 발생")
    void validateHeight(int length) {
        assertThatThrownBy(() -> new Height(length))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_HEIGHT_RANGE.getMessage());
    }
}