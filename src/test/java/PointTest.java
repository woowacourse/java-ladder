import static org.assertj.core.api.Assertions.assertThat;

import domain.Point;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test   //TODO: 있어야할까? 없으면 equals 없앨 수 있는데
    void newPoint() {
        Point point = Point.of(false, true);
        assertThat(point).isEqualTo(Point.of(false, true));
    }
}
