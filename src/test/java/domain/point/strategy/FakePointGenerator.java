package domain.point.strategy;

import domain.point.PointGenerator;

import java.util.List;

public class FakePointGenerator implements PointGenerator {
    private final List<Boolean> points;

    public FakePointGenerator(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public List<Boolean> generate(int count) {
        return points;
    }
}
