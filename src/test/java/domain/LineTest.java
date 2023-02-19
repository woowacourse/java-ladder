package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("true가 연속으로 두 개 나오면 예외를 발생시킨다.")
    void exceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로라인이 연속될 수 없습니다.");
    }

    @Test
    @DisplayName("true가 연속으로 두 개 나오지 않아야 한다.")
    void succeedTest() {
        assertDoesNotThrow(() -> new Line(List.of(false, true, false)));
    }
}
