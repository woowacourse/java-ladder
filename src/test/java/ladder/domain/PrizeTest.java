package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PrizeTest {

    @ParameterizedTest
    @MethodSource("prizeCountProvider")
    @DisplayName("플레이어 이름의 개수와 결과의 개수가 일치하지 않으면 예외를 던진다.")
    void prizeCountTest(List<String> prizes, int playerNamesCount) {
        Assertions.assertThatThrownBy(() -> new Prize(prizes, playerNamesCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 플레이어의 수와 결과의 수를 동일하게 입력하세요.");
    }

    private static Stream<Arguments> prizeCountProvider() {
        return Stream.of(
                Arguments.of(List.of("꽝", "10000", "20000"), 4),
                Arguments.of(List.of("33", "꽝"), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("eachPrizeLengthProvider")
    @DisplayName("각각의 실행 결과 값은 1자이상 5자이하가 아니면 예외를 던진다.")
    void eachPrizeLengthTest(List<String> prizes) {
        Assertions.assertThatThrownBy(() -> new Prize(prizes, prizes.size()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 각각의 실행 결과의 1자이상 5자이하로 입력하세요.");
    }

    private static Stream<Arguments> eachPrizeLengthProvider() {
        return Stream.of(
                Arguments.of(List.of("꽝", "100000", "20000")),
                Arguments.of(List.of("꽝꽝꽝꽝꽝깡", "1900")),
                Arguments.of(List.of(" ", ""))
        );
    }
}
