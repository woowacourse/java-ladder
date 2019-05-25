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

    @Test
    void end_현재_RIGHT() {
        assertThat(Direction.RIGHT.end()).isEqualTo(Direction.LEFT);
    }

    @Test
    void end_현재_LEFT() {
        assertThat(Direction.LEFT.end()).isEqualTo(Direction.NONE);
    }

    @Test
    void end_현재_NONE() {
        assertThat(Direction.NONE.end()).isEqualTo(Direction.NONE);
    }

    @Test
    void next_현재_RIGHT() {
        assertThat(Direction.RIGHT.next(() -> true)).isEqualTo(Direction.LEFT);
        assertThat(Direction.RIGHT.next(() -> false)).isEqualTo(Direction.LEFT);
    }

    @Test
    void next_() {
        assertThat(Direction.LEFT.next(() -> true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.LEFT.next(() -> false)).isEqualTo(Direction.NONE);

        assertThat(Direction.NONE.next(() -> true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.NONE.next(() -> false)).isEqualTo(Direction.NONE);
    }
}
