package domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderResultsTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7,8,9,10,11"})
    @DisplayName("사다리 결과 개수가 부적절(2미만 10초과)할 경우 예외 발생")
    void validateLadderResultsLength(String ladderResults) {
        Assertions.assertThatThrownBy(() -> new LadderResults(Arrays.stream(ladderResults.split(","))
                        .map(LadderResult::new)
                        .toList())).isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_LADDER_RESULTS_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,3,4,5,6,7,8,9,10"})
    @DisplayName("사다리 결과 개수가 적절하면 예외를 발생하지 않음")
    void testLadderResultsCreate(String ladderResults) {
        Assertions.assertThatCode(() -> new LadderResults(Arrays.stream(ladderResults.split(","))
                .map(LadderResult::new)
                .toList())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 결과 개수가 적절하면 해당 개수만큼 반환할 수 있음")
    void testGetLadderResults() {
        List<LadderResult> expected = List.of(new LadderResult("꽝"), new LadderResult("당첨"));
        LadderResults ladderResults = new LadderResults(expected);
        List<LadderResult> actual = ladderResults.getLadderResults();
    }
}