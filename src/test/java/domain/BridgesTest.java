package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BridgesTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        List<Bridge> nonContinuousBridge = List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY, Bridge.BUILT);
        assertThatNoException()
                .isThrownBy(() -> new Bridges(nonContinuousBridge));
    }

    @DisplayName("연속되는 브릿지가 존재하면 예외가 발생한다.")
    @Test
    void constructFailWithContinuousBridge() {
        assertThatThrownBy(() -> new Bridges(List.of(Bridge.BUILT, Bridge.BUILT)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bridges 가 올바른 List 를 반환해야 한다.")
    @MethodSource("getBridgeTestProvider")
    @ParameterizedTest
    void getBridgeTest(List<Bridge> expectedBridges) {
        Bridges bridges = new Bridges(expectedBridges);
        Assertions.assertThat(bridges.getBridges())
                .isEqualTo(expectedBridges);
    }

    static Stream<Arguments> getBridgeTestProvider() {
        return Stream.of(
                Arguments.of(List.of(Bridge.BUILT, Bridge.EMPTY, Bridge.EMPTY, Bridge.BUILT))
        );
    }
}
