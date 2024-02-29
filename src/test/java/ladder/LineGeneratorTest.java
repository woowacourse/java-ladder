package ladder;

import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;
import static ladder.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineGeneratorTest {

    @Test
    @DisplayName("항상 놓는 전략을 사용하는 경우, 올바르게 한 줄을 생성한다.")
    void creationOnAlwaysSuppliesTrue() {
        // given
        LineGenerator lineGenerator = new LineGenerator();
        // when
        Line line = lineGenerator.generate(() -> true, 5);
        List<Direction> expected = List.of(RIGHT, LEFT, RIGHT, LEFT, STRAIGHT);
        // then
        assertThat(line.getDirections()).containsExactlyElementsOf(expected);
    }
}
