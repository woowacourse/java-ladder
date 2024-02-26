package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Paths {
    private final List<Path> paths;

    private Paths(final List<Path> paths) {
        this.paths = paths;
    }

    public static Paths init(Supplier<Boolean> randomGenerator, int ladderSpaceCount) {
        return new Paths(Collections.emptyList());
    }
}
