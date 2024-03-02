package mock;

import domain.Point;
import domain.PointGenerator;

public class RightPointGenerator implements PointGenerator {
    @Override
    public Point generate() {
        return new Point(false, true);
    }

    @Override
    public Point generateFirstPoint() {
        return new Point(false, true);
    }

    @Override
    public Point generateLastPoint() {
        return new Point(true, false);
    }
}
