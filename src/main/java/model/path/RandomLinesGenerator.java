package model.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Line;

public class RandomLinesGenerator implements LinesGenerator {
    private final Random random = new Random();

    @Override
    public List<Line> generate(final int height, final int pathCount) {
        final List<Line> lines = new ArrayList<>();
        while (lines.size() < height) {
            final Line generatedLine = generateLine(pathCount);
            lines.add(generatedLine);
        }
        return lines;
    }

    private Line generateLine(final int pathCount) {
        final List<Path> paths = new ArrayList<>();
        while (paths.size() < pathCount) {
            Path randomPath = getNextPath(paths);
            paths.add(randomPath);
        }
        return new Line(paths);
    }

    private Path getNextPath(final List<Path> paths) {
        if (!paths.isEmpty() && getLastPath(paths) == Path.EXIST) {
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
}
