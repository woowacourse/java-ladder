package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int findLadderResultPosition(int position) {
        int resultPosition = position;
        for (Line line : lines) {
            resultPosition = line.findNextPosition(resultPosition);
        }

        return resultPosition;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
