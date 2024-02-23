package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowTest {
    @Test
    @DisplayName("연속해서 가로 라인이 등장하는지 확인")
    void validateNearInfo() {
        Assertions.assertThatThrownBy(() -> new Row(List.of(true, true)))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.ROW_NEAR.getMessage());
    }
}