package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int ladderHeight, int personCount) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < ladderHeight; index++) {
            lines.add(new Line(personCount));
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }
}
