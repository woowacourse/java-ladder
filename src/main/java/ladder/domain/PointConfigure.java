package ladder.domain;

import java.util.Random;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class PointConfigure {
    public static Point generateRandom(Point prePoint) {
        if (!prePoint.status()) {
            return Point.valueOf(new Random().nextBoolean());
        }

        if (prePoint.status()) {
            return Point.FALSE;
        }

        throw new IllegalArgumentException();
    }
}
