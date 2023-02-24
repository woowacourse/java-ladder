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

    private List<Scaffold> createLine(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        Deque<Scaffold> scaffolds = new ArrayDeque<>();
        final int widthSize = width.getValue();
        for (int i = 0; i < widthSize; i++) {
            scaffolds.add(createScaffold(scaffoldGenerator, scaffolds));
        }
        return new ArrayList<>(scaffolds);
    }

    private Scaffold createScaffold(final ScaffoldGenerator scaffoldGenerator, final Deque<Scaffold> scaffolds) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (isScaffoldExistContinually(scaffold, scaffolds)) {
            return Scaffold.NONE;
        }
        return scaffold;
    }

    private boolean isScaffoldExistContinually(final Scaffold scaffold, final Deque<Scaffold> scaffolds) {
        return scaffold == Scaffold.EXIST && scaffolds.peekLast() == Scaffold.EXIST;
    }

    private void validateScaffolds(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        validateConsistExistScaffolds(scaffolds);
    }

    private void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.isEmpty()) {
            throw new IllegalArgumentException(ERROR_SCAFFOLD_EMPTY);
        }
    }

    private void validateConsistExistScaffolds(final List<Scaffold> scaffolds) {
        IntStream.range(0, scaffolds.size()- 1).forEach(i -> validateConsistExistScaffold(scaffolds, i));
    }

    private void validateConsistExistScaffold(final List<Scaffold> scaffolds, final int index) {
        if (scaffolds.get(index) != scaffolds.get(index + 1)) {
            return;
        }
        if (scaffolds.get(index) == Scaffold.NONE) {
            return;
        }
        throw new IllegalArgumentException(ERROR_SCAFFOLD_SEQUENT);
    }

    public int move(final int position) {
        if (isLeftMovable(position)) {
            return position - 1;
        }
        if (isRightMovable(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean isLeftMovable(final int position) {
        return position > 0 && scaffolds.get(position - 1).isExist();
    }

    private boolean isRightMovable(final int position) {
        return position < scaffolds.size() && scaffolds.get(position).isExist();
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return scaffolds;
    }
}
