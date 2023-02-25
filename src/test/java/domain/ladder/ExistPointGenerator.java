package domain.ladder;

public class ExistPointGenerator implements PointGenerator {

    @Override
    public Point generate() {
        return Point.of(true);
    }

}
