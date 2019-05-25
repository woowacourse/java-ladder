package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void prev() {
        int at = 1;
        Position position = Position.create(at);

        assertThat(position.prev()).isEqualTo(Position.create(at - 1));
    }

    @Test
    void next() {
        int at = 1;
        Position position = Position.create(at);

        assertThat(position.next()).isEqualTo(Position.create(at + 1));
    }

    @Test
    void toInt() {
        int at = 0;
        Position position = Position.create(at);

        assertThat(position.toInt()).isEqualTo(at);
    }
}