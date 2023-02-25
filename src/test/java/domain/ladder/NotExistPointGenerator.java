package domain.ladder;

public class NotExistPointGenerator implements PointGenerator {

    @Override
    public Point generate() {
        return Point.of(false);
    }

}
