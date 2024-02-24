package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultsTest {

    @DisplayName("플레이어의 수와 결과들의 수가 다르면 에러가 발생한다")
    @ParameterizedTest
    @MethodSource("createFailByNonMatchedCountArguments")
    public void createFailByNonMatchedCount(Players players, List<String> inputResults) {
        assertThatCode(() -> new Results(players, inputResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력한 결과의 수는 플레이어의 수와 일치해야 합니다. 입력한 결과 수: %d", inputResults.size()));
    }

    static Stream<Arguments> createFailByNonMatchedCountArguments() {
        return Stream.of(
                arguments(new Players(List.of("pobi", "tommy")), List.of("꽝")),
                arguments(new Players(List.of("pobi", "tommy", "paul")), List.of("꽝", "당첨", "꽝", "당첨2"))
        );
    }

    @DisplayName("플레이어의 수와 결과들의 수가 같으면 에러가 발생하지 않는다")
    @ParameterizedTest
    @MethodSource("createSuccessArguments")
    public void createSuccess(Players players, List<String> inputResults) {
        assertThatCode(() -> new Results(players, inputResults))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> createSuccessArguments() {
        return Stream.of(
                arguments(new Players(List.of("pobi", "tommy")), List.of("꽝", "당첨")),
                arguments(new Players(List.of("pobi", "tommy", "paul", "smith", "dean")),
                        List.of("꽝", "당첨", "꽝", "당첨", "꽝"))
        );
    }

    @DisplayName("입력한 결과들을 반환한다")
    @Test
    public void getResults() {
        Results results = new Results(new Players(List.of("pobi", "tommy")), List.of("꽝", "당첨"));

        assertThat(results.getResults()).isEqualTo(List.of("꽝", "당첨"));
    }
}
