package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultsTest {
    private static Stream<Arguments> inputAndExpectedResult() {
        return Stream.of(
                Arguments.of(new Location(0), new Result("꽝")),
                Arguments.of(new Location(1), new Result("5000"))
        );
    }

    @DisplayName("위치를 입력하여 그 위치의 결과를 반환한다.")
    @MethodSource("inputAndExpectedResult")
    @ParameterizedTest
    void getResultTest(Location location, Result expectedResult) {
        Results results = new Results(List.of(new Result("꽝"), new Result("5000")));

        assertThat(results.getResult(location)).isEqualTo(expectedResult);
    }
}
