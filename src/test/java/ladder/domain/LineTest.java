package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    @BeforeEach
    void setup() {
        Players.NUM_OF_PLAYERS = 3;
        Point first = Point.first(true);
        Point next = first.next(false);
        line = new Line(Arrays.asList(first, next, next.last()));
    }

    @Test
    void firstDirectionTest() {
        Point left = line.getPoint(new Position(0));
        assertThat(left.move()).isEqualTo(Point.RIGHT);
    }

    @Test
    void midDirectionTest() {
        Point left = line.getPoint(new Position(1));
        assertThat(left.move()).isEqualTo(Point.LEFT);
    }

    @Test
    void lastDirectionTest() {
        Point left = line.getPoint(new Position(2));
        assertThat(left.move()).isEqualTo(Point.STRAIGHT);
    }
}
