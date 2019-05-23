package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void nextPosition_LEFT() {
        Position position = new Position(0, 3, 1);

        assertThat(Direction.LEFT.nextPosition(position)).isEqualTo(new Position(0, 3, 0));
    }

    @Test
    void nextPosition_RIGHT() {
        Position position = new Position(0, 3, 1);

        assertThat(Direction.RIGHT.nextPosition(position)).isEqualTo(new Position(0, 3, 2));
    }

    @Test
    void nextPosition_NONE() {
        Position position = new Position(0, 3, 1);

        assertThat(Direction.NONE.nextPosition(position)).isEqualTo(position);
    }
}
