import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test   //TODO: 있어야할까? 없으면 equals 없앨 수 있는데
    @DisplayName("왼쪽, 오른쪽 다리 유무를 갖고 사다리의 한 지점을 생성한다.")
    void newPoint() {
        Point point = Point.of(false, true);
        assertThat(point).isEqualTo(Point.of(false, true));
    }

    @Test
    @DisplayName("양쪽 다 다리가 있는 경우에는 예외를 발생한다.")
    void invalidPoint() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.of(true, true));
    }

    @Test
    @DisplayName("오른쪽에만 다리가 있는 경우에는 가로 위치가 1 증가한다.")
    void moveRight() {
        Point point = Point.of(false, true);
        int resultIndex = point.move(0);
        assertThat(resultIndex).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽에만 다리가 있는 경우에는 가로 위치가 1 감소한다.")
    void moveLeft() {
        Point point = Point.of(true, false);
        int resultIndex = point.move(1);
        assertThat(resultIndex).isEqualTo(0);
    }
}
