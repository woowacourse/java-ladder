package domain.point.strategy;

import domain.point.PointGenerator;

import java.util.List;

public class PointGeneratorStub implements PointGenerator {
    private List<Boolean> points;

    public void setPoints(List<Boolean> points) {
        this.points = points;
    }

    @Override
    public List<Boolean> generate(int count) {
        return points;
    }
}
