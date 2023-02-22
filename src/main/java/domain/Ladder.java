package domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public int getResultIndex(int index) {
        int resultIndex = index;
        for (Line line : lines) {
            resultIndex = getNextIndex(index, line);
        }

        return resultIndex;
    }

    private int getNextIndex(int index, Line line) {
        if (line.canMoveLeft(index)) {
            return index - 1;
        }
        if (line.canMoveRight(index)) {
            return index + 1;
        }

        return index;
    }
}
