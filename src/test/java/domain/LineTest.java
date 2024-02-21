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

    @DisplayName("입력받은 숫자가 2 이상 10 이하가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("heightRangeTestMethod")
    void heightRangeTest(List<Integer> input) {
        Assertions.assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 2 이상 10 이하여야 합니다.");
    }

    private static Stream<Arguments> heightRangeTestMethod() {
        return Stream.of(
                Arguments.arguments(List.of(1)),
                Arguments.arguments(Collections.nCopies(11, 1))
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

    @DisplayName("한 사다리가 결정되면 다음 사다리가 없도록 생성된다.")
    @Test
    void doubleBridgeTest() {
        Line line = new Line(List.of(1,9,2,8,5,5));
        Assertions.assertThat(
                IntStream.rangeClosed(0,5)
                        .mapToObj(line::getValue)
                        .toList()
        ).isEqualTo(List.of(false, true, false, true, false, true));
    }
}
