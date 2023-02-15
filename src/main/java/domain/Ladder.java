package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int ladderHeight) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < ladderHeight; index++) {
            lines.add(new Line());
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }
}
