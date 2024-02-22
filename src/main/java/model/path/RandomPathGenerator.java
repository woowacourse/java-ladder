package model.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPathGenerator implements PathGenerator {
    @Override
    public List<Path> generate(int count) {
        List<Path> paths = new ArrayList<>();
        while (paths.size() < count) {
            Path randomPath = getNextPath(paths);
            paths.add(randomPath);
        }
        return paths;
    }

    private Path getNextPath(List<Path> paths) {
        Random random = new Random();
        if (!paths.isEmpty() && getLastPath(paths) == Path.EXIST) {
            return Path.NOT_EXIST;
        }
        if (random.nextBoolean()) {
            return Path.EXIST;
        }
        return Path.NOT_EXIST;
    }

    private Path getLastPath(List<Path> paths) {
        return paths.get(paths.size() - 1);
    }

}
