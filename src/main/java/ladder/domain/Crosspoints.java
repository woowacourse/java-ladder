package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crosspoints {
    private static final int FIRST_DUMMY_INDEX = 0;
    private static final int LAST_DUMMY_SPACE = 1;
    private static final int NEXT_INDEX = 1;
    private static final int MINIMUM_SIZE = 2;

    private List<Crosspoint> crosspoints = new ArrayList<>();

    Crosspoints(List<Boolean> crossbars) {
        validateSize(crossbars);
        validateFirstAndLastAreDummy(crossbars);
        for (int i = 0; i < crossbars.size() - 1; i++) {
            crosspoints.add(new Crosspoint(crossbars.get(i), crossbars.get(i + NEXT_INDEX)));
        }
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

    public int answerResultIndexOf(int positionOfPlayer) {
        return crosspoints.get(positionOfPlayer)
                .answerResultPositionOf(positionOfPlayer);
    }

    public List<Boolean> getRightSideCrossbars() {
        List<Boolean> rightCrossbars = new ArrayList<>();

        for (Crosspoint crosspoint : crosspoints) {
            rightCrossbars.add(crosspoint.hasRightSideCrossbar());
        }
        return rightCrossbars;
    }

    public int width() {
        return crosspoints.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crosspoints that = (Crosspoints) o;
        return Objects.equals(crosspoints, that.crosspoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosspoints);
    }
}
