package laddergame.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public Ladder generate(final LineSize lineSize, final LadderHeight ladderHeight) {
        final List<Line> lines = Stream.generate(() -> createLine(lineSize))
                .limit(ladderHeight.getHeight())
                .toList();

        return new Ladder(lines);
    }

    private Line createLine(final LineSize lineSize) {
        final List<Point> points = Stream.iterate(generatePoint(), this::decideNextPoint)
                .limit(lineSize.getLineSize())
                .toList();

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
