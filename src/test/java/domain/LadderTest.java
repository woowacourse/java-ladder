package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class LadderTest {
    @DisplayName("사다리 생성시 연속된 다리가 있을경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("ladderGeneratorFailParameter")
    void validateLadderBridgeTest(List<Bridge> input) {
        Assertions.assertThatThrownBy(() -> new Ladder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 생성시 연속된 다리가 없을경우 정상적으로 수행된다.")
    @ParameterizedTest
    @MethodSource("ladderGeneratorSuccessParameter")
    void validateLadderBridgeFailTest(List<Bridge> input) {
        Assertions.assertThatCode(() -> new Ladder(input)).doesNotThrowAnyException();
    }

    static Stream<Arguments> ladderGeneratorFailParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.EXIST, Bridge.NON_EXIST))
        );
    }

    static Stream<Arguments> ladderGeneratorSuccessParameter() {
        return Stream.of(
                Arguments.of(List.of(Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.NON_EXIST, Bridge.NON_EXIST)),
                Arguments.of(List.of(Bridge.NON_EXIST, Bridge.EXIST, Bridge.NON_EXIST, Bridge.EXIST))
        );
    }
}
