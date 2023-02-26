package laddergame.domain;

import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    public Ladder(int playerCount, int height, BooleanGenerator booleanGenerator) {
        this.ladderHeight = new LadderHeight(height);
        this.lines = List.copyOf(generateLines(playerCount, booleanGenerator));
    }

    private List<Line> generateLines(int playerCount, BooleanGenerator booleanGenerator) {
        final List<Line> lines = new ArrayList<>();
        while (!ladderHeight.isMaxHeight(lines.size())) {
            lines.add(new Line(playerCount, booleanGenerator));
        }
        return lines;
    }

    public List<Line> getLadder() {
        return lines;
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
