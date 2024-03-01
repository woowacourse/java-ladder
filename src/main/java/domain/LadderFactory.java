package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderFactory {

    private static final Random RANDOM_GENERATOR = new Random();

    private LadderFactory() {

    }

    public static Ladder createLadder(final Line... lines) {
        return new Ladder(lines);
    }

    public static Ladder createRandomLadder(final int height, final int width) {
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> Line.generate(width,()->false))
                .toList();
        return createLadder(lines.toArray(Line[]::new));
    }
}
