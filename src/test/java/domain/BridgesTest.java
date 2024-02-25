package domain;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgesTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("다리 개수가 부적절(1 미만 9 초과)하면 예외 발생")
    void validateBridgesSize(int bridgesSize) {
        List<Boolean> bridges = IntStream.range(0, bridgesSize).mapToObj(value -> false).toList();
        Assertions.assertThatThrownBy(() -> new Bridges(bridges))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_BRIDGES_RANGE.getMessage());
    }

    @Test
    @DisplayName("연속해서 다리가 등장하면 예외 발생")
    void validateNearInfo() {
        Assertions.assertThatThrownBy(() -> new Bridges(List.of(true, true)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_NEAR_BRIDGE.getMessage());
    }

    @Test
    @DisplayName("연속해서 다리가 등장하지 않고 다리 개수가 적절하면 예외 발생하지 않음")
    void validateCreateBridges() {
        Assertions.assertThatCode(() -> new Bridges(List.of(true, false)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("다리 정보들을 반환할 수 있음")
    void testGetBridges() {
        List<Boolean> expected = List.of(true, false);
        Bridges bridges = new Bridges(expected);

        List<Boolean> actual = bridges.getBridges();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}