package laddergame.domain;

import laddergame.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(int playerCount, LadderHeight ladderHeight, PointGenerator pointGenerator) {
        this.ladderHeight = ladderHeight;
        this.lines = List.copyOf(generateLines(playerCount, pointGenerator));
    }

    private List<Line> generateLines(int playerCount, PointGenerator pointGenerator) {
        List<Line> lines = new ArrayList<>();
        while (!ladderHeight.isEqualTo(lines.size())) {
            lines.add(new Line(playerCount, pointGenerator));
        }
        return lines;
    }

    public List<Line> getLadder() {
        return lines;
    }
}
