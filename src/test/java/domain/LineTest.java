package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LineTest {

    @DisplayName("입력받은 숫자가 1 이상 50 이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("heightRangeTestMethod")
    void heightRangeTest(List<Integer> input) {
        Assertions.assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1 이상 50 이하여야 합니다.");
    }

    private static Stream<Arguments> heightRangeTestMethod() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(Collections.nCopies(51, 1))
        );
    }

    @DisplayName("받은 Integer List 값에 따라 내부 상태를 결정한다.")
    @Test
    void stateDecisionTest() {
        Line line = new Line(List.of(1,9,2,8,4,5));
        Assertions.assertThat(
                IntStream.rangeClosed(0,5)
                .mapToObj(line::getValue)
                .toList()
        ).isEqualTo(List.of(false, true, false, true, false, true));
    }
}
