package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("라인에서 움직일 방향을 표현한다.")
    @Test
    void lineTest() {
        LineGenerator lineGenerator = () -> RIGHT;

        Line line = new Line(4, lineGenerator);

        assertThat(line.getDirectionAt(0)).isEqualTo(RIGHT);
        assertThat(line.getDirectionAt(1)).isEqualTo(LEFT);
        assertThat(line.getDirectionAt(2)).isEqualTo(RIGHT);
        assertThat(line.getDirectionAt(3)).isEqualTo(LEFT);
    }
}
