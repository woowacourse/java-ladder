package model.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Line;

public class RandomPathGenerator implements PathGenerator {
    private final Random random = new Random();

    @Override
    public List<Path> generate(final int count) {
        final List<Path> paths = new ArrayList<>();
        while (paths.size() < count) {
            Path randomPath = getNextPath(paths);
            paths.add(randomPath);
        }
        return paths;
    }

    @Override
    public List<Line> generate(final int height, final int pathCount) {
        return null;
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
