package domain.result;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "012345"})
    @DisplayName("결과 문자 길이가 부적절(1미만, 5초과)하면 예외 발생")
    void validateLadderResultLength(String value) {
        Assertions.assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULT_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " 0 1 "})
    @DisplayName("결과 문자에 공백이 포함되면 예외 발생")
    void validateLadderResultCharacter(String value) {
        Assertions.assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULT_CHARACTER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01234"})
    @DisplayName("결과 문자가 적절하면 예외가 발생하지 않음")
    void testLadderResult(String value) {
        Assertions.assertThatCode(() -> new Result(value))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01234"})
    @DisplayName("결과는 저장된 문자열을 반환할 수 있음")
    void testGetResult(String expected) {
        Result result = new Result(expected);
        String actual = result.getLadderResult();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}