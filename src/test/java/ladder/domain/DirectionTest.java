package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    private final Position basePosition = new Position(0, 3, 1);

    @Test
    void nextPosition_왼쪽() {
        assertThat(Direction.LEFT.nextPosition(basePosition)).isEqualTo(basePosition.add(-1));
    }

    @Test
    void nextPosition_오른쪽() {
        assertThat(Direction.RIGHT.nextPosition(basePosition)).isEqualTo(basePosition.add(1));
    }

    @Test
    void nextPosition_그자리() {
        assertThat(Direction.NONE.nextPosition(basePosition)).isEqualTo(basePosition.add(0));
    }
}
