package domain.result;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultsTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7,8,9,10,11"})
    @DisplayName("결과 개수가 부적절(2미만 10초과)할 경우 예외 발생")
    void validateLadderResultsLength(String ladderResults) {
        Assertions.assertThatThrownBy(() -> new Results(Arrays.stream(ladderResults.split(","))
                        .map(Result::new)
                        .toList())).isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULTS_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3,4,5,6,7,8,9,10"})
    @DisplayName("결과 개수가 적절하면 예외를 발생하지 않음")
    void testLadderResultsCreate(String ladderResults) {
        Assertions.assertThatCode(() -> new Results(Arrays.stream(ladderResults.split(","))
                .map(Result::new)
                .toList())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("결과 개수가 적절하면 해당 개수만큼 반환할 수 있음")
    void testGetLadderResults() {
        List<Result> expected = List.of(new Result("꽝"), new Result("당첨"));
        Results results = new Results(expected);
        List<Result> actual = results.getLadderResults();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("결과 개수가 적절하면 해당 개수를 반환할 수 있음")
    void testCount() {
        List<Result> givenResults = List.of(new Result("꽝"), new Result("당첨"));
        Results results = new Results(givenResults);
        int expected = 2;
        int actual = results.count();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}