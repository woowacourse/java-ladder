package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningResultTest {
    @ParameterizedTest
    @ValueSource(strings = {"","당첨!!!!"," "})
    void winningResultValidateFailTest(String winningResultInput) {
        Assertions.assertThatThrownBy(() -> new WinningResult(winningResultInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"축히힙니다", "꽝"})
    void winningResultValidateSuccessTest(String winningResultInput) {
        Assertions.assertThatCode(() -> new WinningResult(winningResultInput))
                .doesNotThrowAnyException();
    }
}
