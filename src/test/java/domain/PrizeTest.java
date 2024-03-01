package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("실행 결과가 꽝 또는 자연수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"냥", "-2000", "0"})
    void occurExceptionIfPrizeIsNotLoseOrNaturalNumber(String prize) {
        assertThatThrownBy(() -> new Prize(prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Prize.ERROR_IS_NOT_LOSE_OR_NATURAL_NUMBER);
    }
}
