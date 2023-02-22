package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningPrizeTest {

    @DisplayName("공백이 들어오면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void givenBlankChar_thenFailed(final String prize) {
        assertThatThrownBy(() -> new WinningPrize(prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 빈칸이 될 수 없습니다.");
    }

}
