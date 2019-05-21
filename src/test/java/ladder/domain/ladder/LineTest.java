package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 생성되는_direction_수() {
        Line directions = new Line(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT));
        assertThat(directions.getDirections().size()).isEqualTo(3);
    }
}
