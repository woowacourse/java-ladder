package domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
}