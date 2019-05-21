package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Crossbar {
    private static final int FIRST_DUMMY_INDEX = 0;
    private static final int LAST_DUMMY_SPACE = 1;
    private static final int MINIMUM_SIZE = 2;
    private static final int NEXT_INDEX = 1;

    private List<Boolean> crossbars;

    public Crossbar(List<Boolean> crossbars) {
        validateSize(crossbars);
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

    public List<Crosspoint> getCrosspoints() {
        List<Crosspoint> crosspoints = new ArrayList<>();

        for (int i = 0; i < crossbars.size() - LAST_DUMMY_SPACE; i++) {
            crosspoints.add(new Crosspoint(crossbars.get(i), crossbars.get(i + NEXT_INDEX)));
        }

        return crosspoints;
    }
}
