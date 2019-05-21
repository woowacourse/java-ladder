package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 포인트_제자리_이동() {
        assertThat(new Point(new Direction(false, false), 5).move()).isEqualTo(5);
    }

    @Test
    void 포인트_왼쪽_이동() {
        assertThat(new Point(new Direction(true, false), 5).move()).isEqualTo(4);
    }

    @Test
    void 포인트_오른쪽_이동() {
        assertThat(new Point(new Direction(false, true), 5).move()).isEqualTo(6);
    }

    @Test
    void 마지막_포인트_생성() {
        Point point = new Point(new Direction(false, true), 9);
        assertThat(point.nextPoint(10, true)).isEqualTo(new Point(new Direction(true, false), 10));
    }

    @Test
    void 양쪽_디렉션_예외확인() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Point(new Direction(true, true), 5);
        });
    }
}
