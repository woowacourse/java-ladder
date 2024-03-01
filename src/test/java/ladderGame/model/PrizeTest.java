package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", "꽝꽝", "-1", ""})
    @DisplayName("실행 결과에 꽝 또는 0 이상 99999 이하의 숫자가 입력되는 경우 예외처리 된다.")
    void validateUndefinedPrize(String prize) {
        assertThatThrownBy(() -> new Prize(prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 꽝 또는 0 이상 99999 이하의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "0", "10000", "99999"})
    @DisplayName("실행 결과는 꽝 또는 0 이상 99999 이하의 숫자만 입력가능하다.")
    void validateAvailablePrize(String prize) {
        assertThatCode(() -> {
            new Prize(prize);
        }).doesNotThrowAnyException();;
    }
}
