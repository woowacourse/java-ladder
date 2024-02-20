package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("라인에서 움직일 방향을 표현한다.")
    @Test
    void lineTest() {
        LineGenerator lineGenerator = () -> RIGHT;

        Line line = new Line(4, lineGenerator);

        assertThat(line.line).isEqualTo(List.of(RIGHT, LEFT, RIGHT, LEFT));
    }
}
