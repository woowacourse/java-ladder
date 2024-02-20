package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("가로줄은 1과 -1로 표현한다.")
    @Test
    void lineTest() {
        Line line = new Line(4);

        int index = line.line.indexOf(1);

        assertThat(line.line.get(index + 1)).isEqualTo(-1);
    }
}
