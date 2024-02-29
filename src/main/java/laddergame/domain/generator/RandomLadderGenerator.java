package laddergame.domain.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.ladder.Point;

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
        final List<Point> points = Stream.iterate(generatePoint(), point -> point.next(generatePoint()))
                .limit(lineSize.getLineSize())
                .toList();

        return new Line(points);
    }

    private Point generatePoint() {
        return Point.from(random.nextBoolean());
    }
}
