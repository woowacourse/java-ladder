package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void at() {
        Position position = new Position(0, 2, 1);
        int atIdx = 0;

        assertThat(position.at(atIdx)).isEqualTo(new Position(0, 2, atIdx));
    }

    @Test
    void prev() {
        Position position = new Position(0, 2, 1);

        assertThat(position.prev()).isEqualTo(new Position(0, 2, 0));
    }

    @Test
    void next() {
        Position position = new Position(0, 2, 0);

        assertThat(position.next()).isEqualTo(new Position(0, 2, 1));
    }

    @Test
    void toInt() {
        Position position = new Position(0, 2, 0);

        assertThat(position.toInt()).isEqualTo(0);
    }
}