package model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    @Test
    @DisplayName("정상적으로 실행 결과 객체를 생성한다.")
    void createResult() {
        List<String> values = List.of("꽝", "5000", "꽝", "1000");
        var personCount = 4;
        Assertions.assertThatCode(() -> Result.of(values, personCount))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("createInvalidResultSizeParameterProvider")
    @DisplayName("실행결과의 수가 참여자의 수와 맞지 않으면 예외가 발생한다.")
    void createInvalidResultSize(final List<String> values, final int personCount) {
        Assertions.assertThatThrownBy(() -> Result.of(values, personCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> createInvalidResultSizeParameterProvider() {
        return Stream.of(
                Arguments.of(List.of("1", "2", "3"), 4),
                Arguments.of(List.of("1", "2", "3"), 2)
        );
    }
}
