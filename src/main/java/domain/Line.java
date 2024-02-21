package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        points = new ArrayList<>();
        generate(playerCount, booleanGenerator);
    }

    private void generate(int playerCount, BooleanGenerator booleanGenerator) {
        for (int index = 0; index < playerCount; index++) {
            index = makePoint(index, booleanGenerator.generate());
        }
    }

    private int makePoint(int index, boolean isHorizon) {
        if (isHorizon) {
            generateHorizon();
            return index + 1;
        }
        generateVertical();
        return index;
    }

    private void generateHorizon() {
        points.add(new Point(Direction.RIGHT));
        points.add(new Point(Direction.LEFT));
    }

    private void generateVertical() {
        points.add(new Point(Direction.DOWN));
    }

    public int getPointCount() {
        return points.size();
    }

    public List<Point> getPoints() {
        return this.points;
    }
}
