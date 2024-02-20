package ladder.domain;

import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("라인이 비어있으면 예외 발생")
    void validateEmptyLine() {
        Assertions.assertThatThrownBy(() -> new Line(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 가로 라인이 하나이상 있어야 한다.");
    }
}
