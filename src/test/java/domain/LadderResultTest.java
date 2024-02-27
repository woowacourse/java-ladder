package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderResultTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "012345"})
    @DisplayName("사다리 결과 문자 길이가 부적절(1미만, 5초과)하면 예외 발생")
    void validateLadderResultLength(String value) {
        Assertions.assertThatThrownBy(() -> new LadderResult(value))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULT_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " 0 1 "})
    @DisplayName("사다리 결과 문자에 공백이 포함되면 예외 발생")
    void validateLadderResultCharacter(String value) {
        Assertions.assertThatThrownBy(() -> new LadderResult(value))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULT_CHARACTER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01234"})
    @DisplayName("사다리 결과 문자가 적절하면 예외가 발생하지 않음")
    void testLadderResult(String value) {
        Assertions.assertThatCode(() -> new LadderResult(value))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01234"})
    @DisplayName("사다리 결과는 저장된 문자열을 반환할 수 있음")
    void testGetResult(String expected) {
        LadderResult ladderResult = new LadderResult(expected);
        String actual = ladderResult.getLadderResult();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}