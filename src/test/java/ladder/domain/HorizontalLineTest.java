package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {
    private final Position position = new Position(0, 3, 1);
    private final Position leftPosition = position.prev();
    private final Position rightPosition = position.next();

    @Test
    void nextPosition_NONE() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.nextPosition(position)).isEqualTo(position);
    }

    @Test
    void nextPosition_LEFT() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.LEFT, Direction.NONE);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.nextPosition(position)).isEqualTo(leftPosition);
    }

    @Test
    void nextPosition_RIGHT() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.NONE);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.nextPosition(position)).isEqualTo(rightPosition);
    }

    @Test
    void toString_() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.toString()).isEqualTo("     |     |-----|");
    }
}
