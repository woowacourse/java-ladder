package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ResultTest {

    @ParameterizedTest
    @MethodSource("parametersProvider")
    @DisplayName("플레이어 이름의 개수와 결과의 개수가 일치하지 않으면 예외를 던진다.")
    void resultCountTest(List<String> results, int playerNamesCount) {

        Assertions.assertThatThrownBy(() -> new Result(results, playerNamesCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 플레이어의 수와 결과의 수를 동일하게 입력하세요.");
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(List.of("꽝", "10000", "20000"), 4),
                Arguments.of(List.of("33", "꽝"), 0)
        );
    }
}
