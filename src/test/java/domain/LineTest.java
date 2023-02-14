package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("사람수에 따라 라인을 생성한다. (라인수 = 사람수 - 1)")
    void createLine() {
        Line line = new Line(3);
        assertThat(line.size()).isEqualTo(2);
    }
}
