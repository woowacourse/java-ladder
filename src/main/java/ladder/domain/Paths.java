package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static ladder.domain.PathStatus.EXIST;
import static ladder.domain.PathStatus.NONE;

public class Paths {
    private final List<Optional<Path>> paths;

    public Paths(final List<Optional<Path>> paths) {
        this.paths = paths;
    }

    public static Paths init(Supplier<Boolean> randomGenerator, int ladderSpaceCount) {
        List<PathStatus> pathStatuses = generateRandomPathStatuses(randomGenerator, ladderSpaceCount);
        List<Optional<Path>> paths = new ArrayList<>();
        for (int startLineNumber = 1; startLineNumber <= ladderSpaceCount; startLineNumber++) {
            paths.add(convertToPath(pathStatuses.get(startLineNumber - 1), startLineNumber));
        }

        System.out.println(pathStatuses.toString());
        System.out.println(paths.toString());
        return new Paths(paths);
    }

    private static List<PathStatus> generateRandomPathStatuses(Supplier<Boolean> randomGenerator, int ladderSpaceCount) {
        List<PathStatus> pathStatuses = new ArrayList<>();
        for (int startLineNumber = 1; startLineNumber <= ladderSpaceCount; startLineNumber++) {
            generateRandomPathStatus(randomGenerator, pathStatuses, startLineNumber);
        }
        return pathStatuses;
    }

    private static void generateRandomPathStatus(Supplier<Boolean> randomGenerator, List<PathStatus> pathStatuses, int startLineNumber) {
        if (startLineNumber > 1 && pathStatuses.get(startLineNumber - 2) == EXIST) {
            pathStatuses.add(NONE);
            return;
        }
        pathStatuses.add(PathStatus.getStepStatus(randomGenerator.get()));
    }

    private static Optional<Path> convertToPath(PathStatus pathStatus, int startLineNumber) {
        if (!pathStatus.isExist()) {
            return Optional.empty();
        }
        return Optional.of(Path.of(startLineNumber, startLineNumber + 1));
    }

    public List<PathStatus> getPathStatuses() {
        return paths.stream()
                .map(optionalPath -> optionalPath.map(path -> EXIST).orElse(NONE))
                .toList();
    }
}
