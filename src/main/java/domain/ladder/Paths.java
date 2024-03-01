package domain.ladder;

import domain.LineNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Paths {
    private final List<Optional<Path>> paths;

    private Paths(final List<Optional<Path>> paths) {
        this.paths = paths;
    }

    public static Paths init(final Supplier<Boolean> randomGenerator, final int ladderSpaceCount) {
        List<PathStatus> pathStatuses = generateRandomPathStatuses(randomGenerator, ladderSpaceCount);
        return IntStream.rangeClosed(1, ladderSpaceCount)
                .mapToObj(startLineNumber -> convertToPath(pathStatuses.get(startLineNumber - 1), startLineNumber))
                .collect(collectingAndThen(toList(), Paths::new));
    }

    private static List<PathStatus> generateRandomPathStatuses(final Supplier<Boolean> randomGenerator, final int ladderSpaceCount) {
        List<PathStatus> pathStatuses = new ArrayList<>();
        for (int startLineNumber = 1; startLineNumber <= ladderSpaceCount; startLineNumber++) {
            generateRandomPathStatus(randomGenerator, pathStatuses, startLineNumber);
        }
        return pathStatuses;
    }

    private static void generateRandomPathStatus(final Supplier<Boolean> randomGenerator, final List<PathStatus> pathStatuses, final int startLineNumber) {
        Optional<PathStatus> prevPathStatus = findPrevPathStatus(pathStatuses, startLineNumber - 1);
        if (prevPathStatus.isPresent() && prevPathStatus.get() == PathStatus.EXIST) {
            pathStatuses.add(PathStatus.NONE);
            return;
        }
        pathStatuses.add(PathStatus.getStepStatus(randomGenerator.get()));
    }

    private static Optional<PathStatus> findPrevPathStatus(final List<PathStatus> pathStatuses, final int currentIndex) {
        if (currentIndex <= 0) {
            return Optional.empty();
        }
        return Optional.of(pathStatuses.get(currentIndex - 1));
    }

    private static Optional<Path> convertToPath(final PathStatus pathStatus, final int startLineNumber) {
        if (!pathStatus.isExist()) {
            return Optional.empty();
        }
        return Optional.of(Path.of(startLineNumber, startLineNumber + 1));
    }

    public List<PathStatus> getPathStatuses() {
        return paths.stream()
                .map(optionalPath -> optionalPath.map(path -> PathStatus.EXIST).orElse(PathStatus.NONE))
                .toList();
    }

    public int getOtherLineNumber(final LineNumber lineNumber) {
        return parseExistPaths().stream()
                .filter(path -> path.hasPath(lineNumber))
                .findAny()
                .map(path -> path.getOtherLineDistance(lineNumber))
                .orElse(0);
    }

    private List<Path> parseExistPaths() {
        return paths.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
