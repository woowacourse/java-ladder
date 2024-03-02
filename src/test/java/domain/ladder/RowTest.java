package domain.ladder;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RowTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("다리 개수가 부적절(1 미만 9 초과)하면 예외 발생")
    void validateBridgesSize(int bridgesSize) {
        List<Bridge> bridges = IntStream.range(0, bridgesSize).mapToObj(value -> Bridge.NONE).toList();
        Assertions.assertThatThrownBy(() -> new Row(bridges))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_BRIDGES_RANGE.getMessage());
    }

    @Test
    @DisplayName("연속해서 다리가 등장하면 예외 발생")
    void validateNearBridge() {
        Assertions.assertThatThrownBy(() -> new Row(List.of(Bridge.EXIST, Bridge.EXIST)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_NEAR_BRIDGE.getMessage());
    }

    @Test
    @DisplayName("연속해서 다리가 등장하지 않고 다리 개수가 적절하면 예외 발생하지 않음")
    void validateCreateBridges() {
        Assertions.assertThatCode(() -> new Row(List.of(Bridge.EXIST, Bridge.NONE)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("다리 정보들을 반환할 수 있음")
    void testGetBridges() {
        List<Bridge> expected = List.of(Bridge.EXIST, Bridge.NONE);
        Row row = new Row(expected);

        List<Bridge> actual = row.getBridges();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}