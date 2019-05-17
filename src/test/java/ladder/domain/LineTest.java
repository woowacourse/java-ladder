package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @BeforeEach
    void setup() {
        Position.MAX = 2;
    }

    @Test
    void firstDirectionTest() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Direction left = line.getDirection(new Position(0));
        assertThat(left.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void midDirectionTest() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Direction left = line.getDirection(new Position(1));
        assertThat(left.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void lastDirectionTest() {
        Direction first = Direction.first(true);
        Direction next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Direction left = line.getDirection(new Position(2));
        assertThat(left.move()).isEqualTo(Direction.STRAIGHT);
    }
}
