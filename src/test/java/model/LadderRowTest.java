package model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderRowTest {

    @DisplayName("연속된 true 값이 존재하면 예외가 발생한다.")
    @Test
    void consecutiveTrueThrowException() {
        Assertions.assertThatThrownBy(() -> new LadderRow(List.of(true, true, false, false)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("연속된 true 값이 존재하지 않습니다.");
    }
}
