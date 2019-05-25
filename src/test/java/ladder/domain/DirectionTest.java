package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void nextPosition_LEFT() {
        Position position = Position.create(1);

        assertThat(Direction.LEFT.nextPosition(position)).isEqualTo(position.prev());
    }

    @Test
    void nextPosition_RIGHT() {
        Position position = Position.create(1);

        assertThat(Direction.RIGHT.nextPosition(position)).isEqualTo(position.next());
    }

    @Test
    void nextPosition_NONE() {
        Position position = Position.create(1);

        assertThat(Direction.NONE.nextPosition(position)).isEqualTo(position);
    }
}
