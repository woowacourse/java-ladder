package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.ladder.line.Point;
import org.junit.jupiter.api.Test;

class PointTest {
    @Test
    void createFilledPointBy() {
        Point point = Point.of(true);
        assertThat(point).isEqualTo(Point.FILLED);
    }

    @Test
    void createEmptyPoint() {
        Point point = Point.of(false);
        assertThat(point).isEqualTo(Point.EMPTY);
    }

    @Test
    void getIsFilled() {
        Point point = Point.FILLED;
        assertThat(point.isFilled()).isEqualTo(true);
    }

    @Test
    void getIsNotFilled() {
        Point point = Point.EMPTY;
        assertThat(point.isFilled()).isEqualTo(false);
    }
}