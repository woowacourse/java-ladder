package model.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private Path getNextPath(final List<Path> paths) {
        if (isLastPathExist(paths)) {
            return Path.NOT_EXIST;
        }
        if (random.nextBoolean()) {
            return Path.EXIST;
        }
        return Path.NOT_EXIST;
    }

    private boolean isLastPathExist(List<Path> paths) {
        if (paths.isEmpty()) {
            return false;
        }
        return getLastPath(paths).isExist();
    }

    private Path getLastPath(final List<Path> paths) {
        return paths.get(paths.size() - 1);
    }

}
