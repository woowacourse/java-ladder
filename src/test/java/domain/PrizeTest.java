package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @ParameterizedTest
    @DisplayName("결과가 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noPrizeExceptionTest(String prize) {
        assertThatThrownBy(() -> new Prize(prize, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Prize.NO_PRIZE);
    }

}
