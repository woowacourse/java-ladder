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
    @DisplayName("연속해서 가로 라인이 등장하는지 확인")
    void validateNearInfo() {
        Assertions.assertThatThrownBy(() -> new Row(List.of(true, true)))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("연속해서 가로 라인이 등장할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("가로 라인 개수 확인")
    void validateRowInfoSize(int infoSize) {
        List<Boolean> rowInfos = IntStream.range(0, infoSize).mapToObj(value -> false).toList();
        Assertions.assertThatThrownBy(() -> new Row(rowInfos))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("가로 라인 개수는 1이상 9 이하여야 합니다.");
    }
}