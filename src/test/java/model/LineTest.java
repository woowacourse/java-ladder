package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @DisplayName("라인 생성 시 다리가 겹치면 예외가 발생한다")
    @Test
    void testInvalidLine() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 생성 시 다리가 겹치지 않으면 예외가 발생하지 않는다")
    @Test
    void testValidLine() {
        assertDoesNotThrow(() -> new Line(List.of(true, false, true)));
    }
}
