package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public Ladder generate(final LineSize lineSize, final LadderHeight ladderHeight) {
        final List<Line> lines = new ArrayList<>();

        while (ladderHeight.isBiggerThan(lines.size())) {
            lines.add(createLine(lineSize));
        }

        return new Ladder(lines);
    }

    private Line createLine(final LineSize lineSize) {
        List<Point> points = new ArrayList<>();

        Point temp = Point.EMPTY;

        while (lineSize.isBiggerThan(points.size())) {
            final Point point = decideNextPoint(temp);
            points.add(point);
            temp = point;
        }

        return new Line(points);
    }

    private Point decideNextPoint(final Point before) {
        if (before.isExist()) {
            return Point.EMPTY;
        }

        return generatePoint();
    }

    private Point generatePoint() {
        if (random.nextBoolean()) {
            return Point.EXIST;
        }

        return Point.EMPTY;
    }
}
