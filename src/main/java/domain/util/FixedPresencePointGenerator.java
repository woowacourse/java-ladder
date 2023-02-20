package domain.util;

public class FixedPresencePointGenerator implements PointGenerator {
    @Override
    public Point generate() {
        return Point.from(true);
    }
}
