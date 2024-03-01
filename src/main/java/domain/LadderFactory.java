package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderFactory {

    private static final Random RANDOM_GENERATOR = new Random();

    private LadderFactory() {

    }

    public static Ladder createLadder(final List<Line> lines) {
        return new Ladder(lines.toArray(Line[]::new));
    }

    public static Ladder createRandomLadder(final int height, final int width) {
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> Line.generate(width, new StateGenerator()))
                .toList();
        return createLadder(lines);
    }
}
