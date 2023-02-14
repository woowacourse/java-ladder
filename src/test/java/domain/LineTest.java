package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("사람수에 따라 라인을 생성한다. (라인수 = 사람수 - 1)")
    void createLine() {
        Line line = new Line(3);
        assertThat(line.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("true가 연속으로 두 개 나오면 예외를 발생시킨다.")
    void exceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("연속된 true가 나올 수 없습니다.");
    }

    @Test
    @DisplayName("true가 연속으로 두 개 나오지 않아야 한다.")
    void succeedTest() {
        assertDoesNotThrow(() -> new Line(List.of(true, false, false)));
    }
}
