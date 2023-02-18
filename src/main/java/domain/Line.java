package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Line {

    private final List<Scaffold> scaffolds;

    public Line(final List<Scaffold> scaffolds) {
        validate(scaffolds);
        this.scaffolds = new ArrayList<>(scaffolds);
    }

    private void validate(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        validateConsistExistScaffolds(scaffolds);
    }

    private void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로 길이는 0일수 없습니다.");
        }
    }

    private void validateConsistExistScaffolds(final List<Scaffold> scaffolds) {
        Deque<Scaffold> scaffoldDeque = new ArrayDeque<>(scaffolds);
        scaffolds.forEach(it -> validateConsistExistScaffold(scaffoldDeque));
    }

    private void validateConsistExistScaffold(final Deque<Scaffold> scaffolds) {
        Scaffold beforeScaffold = scaffolds.removeFirst();
        if (beforeScaffold != scaffolds.peekFirst()) {
            return;
        }
        if (beforeScaffold == Scaffold.NONE) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return new ArrayList<>(scaffolds);
    }
}
