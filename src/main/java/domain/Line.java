package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final String ERROR_SCAFFOLD_EMPTY = "[ERROR] 발판이 생성되지 않았습니다";
    private static final String ERROR_SCAFFOLD_SEQUENT = "[ERROR] 발판이 연속으로 생성되었습니다";
    private final List<Scaffold> scaffolds;

    public Line(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        this.scaffolds = createLine(width, scaffoldGenerator);
        validateScaffolds(scaffolds);
    }

    public List<Scaffold> createLine(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        Deque<Scaffold> scaffolds = new ArrayDeque<>();
        for (int i = 0; i < width.getValue(); i++) {
            scaffolds.add(createNonConsistScaffold(scaffoldGenerator, scaffolds));
        }
        return new ArrayList<>(scaffolds);
    }

    private Scaffold createNonConsistScaffold(final ScaffoldGenerator scaffoldGenerator, final Deque<Scaffold> scaffolds) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffold == Scaffold.EXIST && scaffolds.peekLast() == Scaffold.EXIST) {
            return Scaffold.NONE;
        }
        return scaffold;
    }

    private static void validateScaffolds(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        validateConsistExistScaffolds(scaffolds);
    }

    private static void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.isEmpty()) {
            throw new IllegalArgumentException(ERROR_SCAFFOLD_EMPTY);
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
        throw new IllegalArgumentException(ERROR_SCAFFOLD_SEQUENT);
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return scaffolds;
    }
}
