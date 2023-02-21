package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;
    private List<String> ladderResults;

    public Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
    }

    public Ladder(List<Line> lines, LadderHeight ladderHeight, List<String> ladderResults) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
        this.ladderResults = new ArrayList<>(ladderResults);
    }

    public String play(int position) {
        for (Line line : lines) {
            position = move(position, line);
        }

        return ladderResults.get(position - 1);
    }

    private int move(int position, Line line) {
        List<LinePoint> points = line.getPoints();
        int idx = position - 1;

        if (idx != 0 && points.get(idx - 1).isPassable()) {
            return --position;
        }

        if (idx != points.size() && points.get(idx).isPassable()) {
            return ++position;
        }

        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<String> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
