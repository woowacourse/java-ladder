package laddergame.domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
        this.ladderHeight = new LadderHeight(lines.size());
    }

    public List<Line> getLadder() {
        return lines;
    }
}
