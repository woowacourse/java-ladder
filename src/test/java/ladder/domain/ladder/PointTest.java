package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    @Test
    void 포인트생성() {
        assertThat(Point.firstPoint(true).nextPoint(2, false))
                .isEqualTo(Point.of(1, Direction.of(true, false)));
    }

    @Test
    void 포인트생성불가() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point.firstPoint(true).nextPoint(0, false);
        });
    }

    @Test
    void 다음포인트포지션얻기() {
        Point point = Point.of(1, Direction.of(true, false));
        assertThat(point.nextPointPosition()).isEqualTo(0);
    }

    @Test
    void 왼쪽방향포인트() {
        Point point = Point.of(1, Direction.of(true, false));
        assertThat(point.isRightDirection()).isFalse();
    }

    @Test
    void 오른쪽방향포인트() {
        Point point = Point.of(1, Direction.of(false, true));
        assertThat(point.isRightDirection()).isTrue();
    }
}
