import domain.NumberGenerator;
import domain.Point;
import domain.PointFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointFactoryTest {
    @Test
    void name1() {
        NumberGenerator zeroGenerator = new ZeroNumberGenerator();
        PointFactory pointFactory = new PointFactory(zeroGenerator, 2);
        assertThat(pointFactory.canBuild()).isFalse();
    }

    @Test
    void name2() {
        NumberGenerator oneGenerator = new OneGenerator();
        PointFactory pointFactory = new PointFactory(oneGenerator, 2);
        assertThat(pointFactory.canBuild()).isTrue();
    }

    @Test
    void name3() {
        NumberGenerator oneGenerator = new OneGenerator();
        PointFactory pointFactory = new PointFactory(oneGenerator, 2);
        assertThat(pointFactory.generate()).isEqualTo(new Point(true));
    }

    @Test
    void manyPoint() {
        NumberGenerator oneGenerator = new OneGenerator();
        PointFactory pointFactory = new PointFactory(oneGenerator, 2);
        Point point = new Point(true);
        assertThat(pointFactory.generatePoints()).contains(point, point);
    }

    @Test
    void manyPoint2() {
        NumberGenerator oneGenerator = new OneGenerator();
        PointFactory pointFactory = new PointFactory(oneGenerator, 3);
        Point point = new Point(true);
        Point falsePoint = new Point(false);
        assertThat(pointFactory.generatePoints()).contains(point, point, falsePoint);
    }

    @Test
    void manyPoint3() {
        NumberGenerator oneGenerator = new OneGenerator();
        PointFactory pointFactory = new PointFactory(oneGenerator, 3);
        Point point = new Point(true);
        Point falsePoint = new Point(false);
        assertThat(pointFactory.generatePoints()).containsExactly(point, falsePoint, falsePoint);
    }


    private static class ZeroNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 0;
        }
    }

    private static class OneGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 1;
        }
    }


}
