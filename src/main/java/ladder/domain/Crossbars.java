package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Crossbars {
    private static final int FIRST_DUMMY_INDEX = 0;
    private static final int LAST_DUMMY_SPACE = 1;
    private static final int NEIGHBOR_INDEX = 1;
    private static final int MINIMUM_SIZE = 2;

    private List<Boolean> crossbars;

    Crossbars(List<Boolean> crossbars) {
        validateSize(crossbars);
        vaildateNeighboredCrossbar(crossbars);
        validateFirstAndLastAreDummy(crossbars);
        this.crossbars = crossbars;
    }

    private void validateSize(List<Boolean> crossbars) {
        if (crossbars.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException("crossbar의 크기가 잘못되었습니다.");
        }
    }

    private void validateFirstAndLastAreDummy(List<Boolean> crossbars) {
        if (crossbars.get(FIRST_DUMMY_INDEX) || crossbars.get(crossbars.size() - LAST_DUMMY_SPACE)) {
            throw new IllegalArgumentException("첫번째와 마지막번째는 dummy여야 합니다.");
        }
    }

    private void vaildateNeighboredCrossbar(List<Boolean> crossbars) {
        for (int i = 1; i < crossbars.size() - 1; i++) {
            throwExceptionIfBothAreNeighbor(crossbars.get(i), crossbars.get(i + NEIGHBOR_INDEX));
        }
    }

    private void throwExceptionIfBothAreNeighbor(boolean crossbarA, boolean crossbarB) {
        if (crossbarA && crossbarB) {
            throw new IllegalArgumentException("연속된 다리는 만들 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crossbars crossbars1 = (Crossbars) o;
        return Objects.equals(crossbars, crossbars1.crossbars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crossbars);
    }
}
