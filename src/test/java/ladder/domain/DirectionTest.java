package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {
    Direction trueFalse = Direction.first(new AlwaysTrue()).next(false);
    Direction falseTrue = Direction.first(new AlwaysTrue());
    Direction falseFalse = Direction.first(new AlwaysTrue()).next(false).last();

    @Test
    void init_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.first(new AlwaysTrue()).next(true);
        });
    }

    @Test
    void move_left() {
        assertThat(trueFalse.move()).isEqualTo(-1);
    }

    @Test
    void move_right() {
        assertThat(falseTrue.move()).isEqualTo(1);
    }

    @Test
    void move_none() {
        assertThat(falseFalse.move()).isEqualTo(0);
    }

    @Test
    void move_next() {
        assertThat(falseFalse.next(true)).isEqualTo(falseTrue);
    }

    @Test
    void first() {
        Direction direction = Direction.first(new AlwaysTrue());
        assertThat(direction).isEqualTo(falseTrue);
    }

    @Test
    void last() {
        Direction direction = Direction.first(new AlwaysTrue()).last();
        assertThat(direction).isEqualTo(trueFalse);
    }
}
