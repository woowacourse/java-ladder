package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ResultInputViewTest {

    static Stream<Arguments> validateResultLengthParameter() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("abcdef,a", 2)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있는지 확인")
    void validateSeparator(String results) {
        Assertions.assertThatThrownBy(() -> ResultInputView.getResults(() -> results, 3))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.RESULTS_SEPARATOR.getMessage());
    }

    @Test
    @DisplayName("실행 결과 최대 개수 검사")
    void validateResultsCount() {
        Assertions.assertThatThrownBy(() -> ResultInputView.getResults(() -> "a,b,c,d,e,f,g,h,i,j,k", 11))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.RESULTS_COUNT_RANGE.getMessage());
    }

    @Test
    @DisplayName("실행 결과 개수가 이름의 개수와 같은지 검사")
    void validateResultsCountSameAsNamesCount() {
        Assertions.assertThatThrownBy(() -> ResultInputView.getResults(() -> "a,b,c", 4))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.RESULT_COUNT.getMessage());
    }

    @ParameterizedTest
    @MethodSource("validateResultLengthParameter")
    @DisplayName("실행 결과 길이 검증")
    void validateResultLength(String result, int resultCount) {
        assertThatThrownBy(() -> ResultInputView.getResults(() -> result, 2))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.RESULT_LENGTH.getMessage());
    }

    @Test
    @DisplayName("정상 동작 테스트")
    void getResults() {
        List<String> results = ResultInputView.getResults(() -> "당첨,꽝,꽝", 3);
        List<String> expected = List.of("당첨", "꽝", "꽝");
        Assertions.assertThat(results)
                .containsExactlyElementsOf(expected);
    }
}
