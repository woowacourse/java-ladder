package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class DrawnHorizontalLineTest {

    @Test
    void nextPosition_왼쪽() {
        int numPosition = 3; // [0, 3)
        Position current = new Position(0, numPosition, 1);
        DrawnHorizontalLine line = new DrawnHorizontalLine(Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.NONE));

        Position next = line.nextPosition(current);

        assertThat(next).isEqualTo(current.plus(-1));
    }

    @Test
    void nextPosition_오른쪽() {
        int numPosition = 3; // [0, 3)
        Position current = new Position(0, numPosition, 1);
        DrawnHorizontalLine line = new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.RIGHT, Direction.LEFT));

        Position next = line.nextPosition(current);

        assertThat(next).isEqualTo(current.plus(1));
    }

    @Test
    void nextPosition_그자리() {
        int numPosition = 3; // [0, 3)
        Position current = new Position(0, numPosition, 1);
        DrawnHorizontalLine line = new DrawnHorizontalLine(Arrays.asList(Direction.NONE, Direction.NONE, Direction.NONE));

        Position next = line.nextPosition(current);

        assertThat(next).isEqualTo(current.plus(0));
    }
}