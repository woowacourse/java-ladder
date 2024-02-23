package laddergame.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.Point;
import laddergame.domain.Points;
import laddergame.util.BooleanGenerator;
import laddergame.util.RandomBooleanGenerator;

public class PointBuildStrategy implements BuildStrategy {
    private final BooleanGenerator generator = RandomBooleanGenerator.getGenerator();

    @Override
    public Points build(final int count) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(generator.generate()));
        IntStream.range(0, count - 1).forEach(i -> addBuildResult(list));

        return new Points(list.stream().toList());
    }

    private void addBuildResult(List<Point> points) {
        if (points.get(points.size() - 1).isBuilt()) {
            points.add(new Point(false));
            return;
        }
        points.add(new Point(generator.generate()));
    }
}
