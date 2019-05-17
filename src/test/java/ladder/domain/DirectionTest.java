package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void move_left() {
        Direction direction = new Direction(true,false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_right() {
        Direction direction = new Direction(false,true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_none() {
        Direction direction = new Direction(false,false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void move_next() {
        Direction direction = new Direction(false,false);
        assertThat(direction.next(true)).isEqualTo(new Direction(false,true));

    }

}
