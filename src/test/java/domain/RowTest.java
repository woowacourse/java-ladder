package domain;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RowTest {
    @Test
    @DisplayName("연속해서 다리가 등장하면 예외 발생")
    void validateNearInfo() {
        Assertions.assertThatThrownBy(() -> new Row(List.of(true, true)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_NEAR_BRIDGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {Row.MIN_BRIDGES_COUNT - 1, Row.MAX_BRIDGES_COUNT + 1})
    @DisplayName("다리 개수가 부적절(1 미만 9 초과)하면 예외 발생")
    void validateBridgesSize(int bridgesSize) {
        List<Boolean> bridges = IntStream.range(0, bridgesSize).mapToObj(value -> false).toList();
        Assertions.assertThatThrownBy(() -> new Row(bridges))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_BRIDGES_RANGE.getMessage());
    }
}