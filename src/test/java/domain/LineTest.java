package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("생성 테스트")
    @Test
    void createLine() {
        Assertions.assertThatCode(() -> new Line())
                .doesNotThrowAnyException();
    }
}
