package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
