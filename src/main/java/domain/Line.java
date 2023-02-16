package domain;

import java.util.List;

public class Line {
    private final List<Scaffold> scaffolds;

    public Line(final List<Scaffold> scaffolds) {
        validateScaffolds(scaffolds);
        this.scaffolds = scaffolds;
    }

    private static void validateScaffolds(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        validateConsistExistScaffolds(scaffolds);
    }

    private static void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateConsistExistScaffolds(final List<Scaffold> scaffolds) {
        for (int i = 0; i < scaffolds.size() - 1; i++) {
            validateConsistExistScaffold(scaffolds, i);
        }
    }

    private static void validateConsistExistScaffold(final List<Scaffold> scaffolds, final int index) {
        if (scaffolds.get(index) != scaffolds.get(index + 1)) {
            return;
        }
        if (scaffolds.get(index) == Scaffold.NONE) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return scaffolds;
    }
}
