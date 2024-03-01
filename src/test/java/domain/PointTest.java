package domain;

import static domain.Direction.LEFT;
import static domain.Direction.RIGHT;
import static domain.Direction.STRAIGHT;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {
    @Test
    @DisplayName("각 지점에서 이동 시 적절한 지점으로 이동하는지 확인")
    void next() {
        // |-----|     |-----|     |
        //Todo 생성시에 올바를 Point 들인지 확인할 수 있어야 함
        List<Point> points = List.of(new Point(RIGHT), new Point(LEFT, 1), new Point(RIGHT, 2), new Point(LEFT, 3),
                new Point(STRAIGHT, 4));
        Assertions.assertThat(points.get(0).next()).isEqualTo(points.get(1));
        Assertions.assertThat(points.get(1).next()).isEqualTo(points.get(0));
        Assertions.assertThat(points.get(2).next()).isEqualTo(points.get(3));
        Assertions.assertThat(points.get(3).next()).isEqualTo(points.get(2));
        Assertions.assertThat(points.get(4).next()).isEqualTo(points.get(4));
    }
}
