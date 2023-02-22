package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LineTest {
    @DisplayName("사다리 생성시 연속된 다리가 있을경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("lineGeneratorFailParameter")
    void validateLineBridgeTest(List<Bridge> input) {
        Assertions.assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 생성시 연속된 다리가 없을경우 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("lineGeneratorSuccessParameter")
    void validateLineBridgeFailTest(List<Bridge> input) {
        Assertions.assertThatCode(() -> new Line(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("현재 유저가 오른쪽으로 이동가능 여부를 boolean으로 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,true", "1,false"})
    void checkRightBridgeTest(final int index, final boolean result) {
        Line line = new Line(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST));
        Assertions.assertThat(line.checkRight(index)).isEqualTo(result);
    }

    static Stream<Arguments> lineGeneratorFailParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST))
        );
    }

    static Stream<Arguments> lineGeneratorSuccessParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
        );
    }
}
