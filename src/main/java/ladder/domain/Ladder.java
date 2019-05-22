package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    int moveStartToEnd(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.drawLadder());
        }
        return sb.toString();
    }
}
