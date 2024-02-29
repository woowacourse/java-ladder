package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public record Line(List<Boolean> scaffolds) {
    private static final String SCAFFOLD_NOT_LINK = "좌우 연속해서 발판이 존재할 수 없습니다.";

    public Line(List<Boolean> scaffolds) {
        this.scaffolds = new ArrayList<>(scaffolds);
        validateScaffoldNotLinked(this.scaffolds);
    }

    private static IntStream getScaffoldIndexesExceptLast(List<Boolean> scaffolds) {
        return IntStream.range(0, scaffolds.size() - 1);
    }

    private void validateScaffoldNotLinked(List<Boolean> scaffolds) {
        if (getScaffoldIndexesExceptLast(scaffolds)
                .anyMatch(i -> isLinkedWithNext(scaffolds, i))) {
            throw new IllegalArgumentException(SCAFFOLD_NOT_LINK);
        }
    }

    private boolean isLinkedWithNext(List<Boolean> scaffolds, int index) {
        return scaffolds.get(index) && scaffolds.get(index + 1);
    }

    @Override
    public List<Boolean> scaffolds() {
        return List.copyOf(scaffolds);
    }
}
