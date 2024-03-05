package model.ladder.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import model.ladder.Height;

public class RandomLinesGenerator implements LinesGenerator {
    private final Random random = new Random();

    @Override
    public List<Line> generate(final Height height, final int pathCount) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(i -> generateLine(pathCount))
                .toList();
    }

    private Line generateLine(final int pathCount) {
        final List<Path> paths = new ArrayList<>();
        while (paths.size() < pathCount) {
            paths.add(getNextRandomPath(paths));
        }
        return new Line(paths);
    }

    private Path getNextRandomPath(final List<Path> paths) {
        if (!paths.isEmpty() && existLastPath(paths)) {
            return Path.NOT_EXIST;
        }
        if (random.nextBoolean()) {
            return Path.EXIST;
        }
        return Path.NOT_EXIST;
    }

    private Path getLastPath(final List<Path> paths) {
        return paths.get(paths.size() - 1);
    }

    private boolean existLastPath(final List<Path> paths) {
        return getLastPath(paths) == Path.EXIST;
    }
}
