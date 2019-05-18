package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionsTest {
    @Test
    void 생성되는_direction_수() {
        Directions directions = new Directions(8);
        assertThat(directions.getDirections().size()).isEqualTo(8);
    }
}
