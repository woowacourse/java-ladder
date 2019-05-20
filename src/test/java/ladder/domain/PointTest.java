package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    Point point;

    @Test
    void 생성_오류_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Point(true, 0, true));
    }

    @Test
    void 다음_생성_false_true_테스트() {
        point = new Point(false, 0, true);
        Point testPoint = Point.nextPoint(point);
        assertThat(testPoint.move()).isEqualTo(-1);
    }

    @Test
    void 마지막_생성_테스트() {
        point = new Point(false, 0, true);
        Point testPoint = Point.lastPoint(point);
        assertThat(testPoint.toString()).isEqualTo("     ");
    }

    @Test
    void 오른쪽_움직임_테스트() {
        point = new Point(false, 0, true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void 왼쪽_움직임_테스트() {
        point = new Point(true, 0, false);
        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    void 아래로_움직임_테스트() {
        point = new Point(false, 0, false);
        assertThat(point.move()).isEqualTo(0);
    }
}
