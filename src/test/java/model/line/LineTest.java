package model.line;

import static model.bridge.Bridge.CONNECTED;
import static model.bridge.Bridge.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import model.bridge.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {

    @DisplayName("라인 생성 시 다리가 겹치면 다리가 겹치지 않게 조정 후 생성")
    @ParameterizedTest
    @MethodSource("provideDuplicatedBridges")
    void testInvalidLine(List<Bridge> beforeBridges, List<Bridge> afterBridges) {
        assertThat(Line.of(beforeBridges).getBridges())
            .isEqualTo(afterBridges);
    }

    private static Stream<Arguments> provideDuplicatedBridges() {
        return Stream.of(
            Arguments.of(
                List.of(CONNECTED, CONNECTED, UNCONNECTED),
                List.of(CONNECTED, UNCONNECTED, UNCONNECTED)),
            Arguments.of(
                List.of(UNCONNECTED, CONNECTED, CONNECTED, UNCONNECTED),
                List.of(UNCONNECTED, CONNECTED, UNCONNECTED, UNCONNECTED))
        );
    }

    @DisplayName("라인 생성 시 다리가 겹치지 않으면 그대로 생성")
    @ParameterizedTest
    @MethodSource("provideUniqueBridges")
    void testValidLine(List<Bridge> beforeBridges, List<Bridge> afterBridges) {
        assertThat(Line.of(beforeBridges).getBridges())
            .isEqualTo(afterBridges);
    }

    private static Stream<Arguments> provideUniqueBridges() {
        return Stream.of(
            Arguments.of(
                List.of(CONNECTED, UNCONNECTED, CONNECTED),
                List.of(CONNECTED, UNCONNECTED, CONNECTED)),
            Arguments.of(
                List.of(UNCONNECTED, CONNECTED, UNCONNECTED, CONNECTED),
                List.of(UNCONNECTED, CONNECTED, UNCONNECTED, CONNECTED))
        );
    }
}
