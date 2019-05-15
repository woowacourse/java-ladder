package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int ladderHeight, int countPerson) {
        validateLadderHeight(ladderHeight);
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countPerson));
        }
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
