package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorizontalLineTest {
    private final Position position = Position.create(1);
    private final Position leftPosition = position.prev();
    private final Position rightPosition = position.next();

    //
    @Test
    void 생성자_맨_왼쪽_LEFT() {
        List<Direction> directions = Arrays.asList(Direction.LEFT, Direction.NONE);

        assertThrows(IllegalArgumentException.class, () -> new HorizontalLine(directions));
    }

    @Test
    void 생성자_맨_오른쪽_RIGHT() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.NONE);

        assertThrows(IllegalArgumentException.class, () -> new HorizontalLine(directions));
    }

    @Test
    void 생성자_RIGHT_LEFT_아닌경우() {
        // right, right
        // right, none
        // left, left
        // none, left
        List<List<Direction>> inputs = Arrays.asList(
                Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.RIGHT, Direction.NONE),
                Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.NONE, Direction.NONE),
                Arrays.asList(Direction.NONE, Direction.LEFT, Direction.LEFT, Direction.NONE),
                Arrays.asList(Direction.NONE, Direction.NONE, Direction.LEFT, Direction.NONE)
        );

        for (List<Direction> directions : inputs) {
            assertThrows(IllegalArgumentException.class, () -> new HorizontalLine(directions));
        }
    }

    @Test
    void nextPosition_NONE() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.nextPosition(position)).isEqualTo(position);
    }

    @Test
    void nextPosition_LEFT() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE);
        HorizontalLine line = HorizontalLine.from(directions);

        assertThat(line.nextPosition(position)).isEqualTo(leftPosition);
    }

    @Test
    void nextPosition_RIGHT() {
        List<Direction> directions = Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT);
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
