package domain.result;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class PrizesTest {

    @DisplayName("2개 이상의 결과를 포함할 경우 정상적으로 객체가 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Prizes(List.of("1", "2")));
    }

    @DisplayName("2개 미만의 결과로 객체를 생성할 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("getSmallResultsTestProvider")
    void constructFailWithTooSmallResults(List<String> results) {
        assertThatThrownBy(() -> new Prizes(results))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<List<String>> getSmallResultsTestProvider() {
        return Stream.of(
                List.of(),
                List.of("1")
        );
    }
}
