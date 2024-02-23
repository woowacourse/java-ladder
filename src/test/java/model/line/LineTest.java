package model.line;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import model.bridge.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {
    @DisplayName("라인 생성 시 다리가 겹치면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideDuplicatedBridges")
    void testInvalidLine(List<Bridge> bridges) {
        assertThatThrownBy(() -> new Line(bridges))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideDuplicatedBridges() {
        return Stream.of(
                Arguments.of(createBridges(List.of(1, 1, 0))),
                Arguments.of(createBridges(List.of(0, 1, 1, 0)))
        );
    }

    @DisplayName("라인 생성 시 다리가 겹치지 않으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @MethodSource("provideUniqueBridges")
    void testValidLine(List<Bridge> bridges) {
        assertDoesNotThrow(() -> new Line(bridges));
    }

    private static Stream<Arguments> provideUniqueBridges() {
        return Stream.of(
                Arguments.of(createBridges(List.of(1, 0, 1))),
                Arguments.of(createBridges(List.of(0, 1, 0, 1)))
        );
    }

    private static List<Bridge> createBridges(List<Integer> codes) {
        return codes.stream()
                .map(code -> Bridge.findBridgeByCode(code).orElse(null))
                .toList();
    }
}
