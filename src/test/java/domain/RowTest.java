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
    @DisplayName("연속해서 다리가 등장하는지 확인")
    void validateNearInfo() {
        Assertions.assertThatThrownBy(() -> new Row(List.of(true, true)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.ROW_NEAR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {Row.MIN_BRIDGES_COUNT - 1, Row.MAX_BRIDGES_COUNT + 1})
    @DisplayName("다리 개수 확인")
    void validateRowInfoSize(int infoSize) {
        List<Boolean> bridges = IntStream.range(0, infoSize).mapToObj(value -> false).toList();
        Assertions.assertThatThrownBy(() -> new Row(bridges))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.ROW_BRIDGES_COUNT.getMessage());
    }
}