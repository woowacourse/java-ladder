package ladder.domain;

import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int getLastPosition(int playerPosition) {
        int lastPosition = playerPosition;
        for (Line line : lines) {
            lastPosition = line.getNextPosition(lastPosition);
        }

        return lastPosition;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
