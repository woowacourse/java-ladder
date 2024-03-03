package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WidthTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("다리 폭이 부적절(2 미만 10 이상)하면 예외 발생")
    void validateWidth(int length) {
        assertThatThrownBy(() -> new Width(length))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_WIDTH_RANGE.getMessage());
    }
}