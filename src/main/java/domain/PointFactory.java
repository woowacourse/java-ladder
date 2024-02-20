package domain;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {
    private final NumberGenerator randomNumberGenerator;
    private final int count;

    public PointFactory(NumberGenerator randomNumberGenerator, int count) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.count = count;
    }

    public boolean canBuild() {
        if (randomNumberGenerator.generate() == 0) {
            return false;
        }
        return true;
    }

    public Point generate() {
       if (canBuild()) {
           return new Point(true);
       }
       return new Point(false);
    }

    public List<Point> generatePoints() {
        List<Point> points = new ArrayList<>();
        Point truePoint = new Point(true);
        Point falsePoint = new Point(false);
        points.add(generate());
        for (int i = 1; i < count - 1; i++) {
            if (points.get(i-1).equals(truePoint)) {
                points.add(falsePoint);
            }
            if (points.get(i-1).equals(falsePoint)) {
                points.add(generate());
            }
        }
        points.add(falsePoint);
        return points;
    }
}
