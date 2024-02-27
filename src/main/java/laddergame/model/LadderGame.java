package laddergame.model;

import java.util.List;

public class LadderGame {
    private final List<Line> lines;

    public LadderGame(List<Line> lines) {
        this.lines = lines;
    }

    public int climb(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLines() {
        return lines;
    }
}
