package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
    }

    @Test
    void firstDirectionTest() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Point left = line.getPoint(new Position(0));
        assertThat(left.move()).isEqualTo(Point.RIGHT);
    }

    @Test
    void midDirectionTest() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Point left = line.getPoint(new Position(1));
        assertThat(left.move()).isEqualTo(Point.LEFT);
    }

    @Test
    void lastDirectionTest() {
        Point first = Point.first(true);
        Point next = first.next(false);
        Line line = new Line(Arrays.asList(first, next, next.last()));
        Point left = line.getPoint(new Position(2));
        assertThat(left.move()).isEqualTo(Point.STRAIGHT);
    }
}
