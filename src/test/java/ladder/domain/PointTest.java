package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void consecutiveTrueTest() {
        assertThrows(RuntimeException.class, () -> {
            Point first = Point.first(true);
            first.next(true);
        });
    }

    @Test
    void leftTest() {
        Point first = Point.first(true);
        Point left = first.next(false);
        assertThat(left.move()).isEqualTo(Point.LEFT);
    }

    @Test
    void rightTest() {
        Point first = Point.first(false);
        Point right = first.next(true);
        assertThat(right.move()).isEqualTo(Point.RIGHT);
    }

    @Test
    void straightTest() {
        Point first = Point.first(false);
        Point straight = first.next(false);
        assertThat(straight.move()).isEqualTo(Point.STRAIGHT);
    }

    @Test
    void firstNoLeftTest() {
        Point first = Point.first(true);
        assertThat(first.move()).isNotEqualTo(Point.LEFT);
        first = Point.first(false);
        assertThat(first.move()).isNotEqualTo(Point.LEFT);
    }

    @Test
    void lastNoRightTest() {
        Point point = Point.first(true);
        assertThat(point.last().move()).isNotEqualTo(Point.RIGHT);
        point = Point.first(false);
        assertThat(point.last().move()).isNotEqualTo(Point.RIGHT);
    }
}
