package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 생성되는_direction_수() {
        Line directions = new Line(8);
        assertThat(directions.getDirections().size()).isEqualTo(8);
    }
}
