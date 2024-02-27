package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int findLadderResultIndex(int index) {
        int resultIndex = index;
        for (Line line : lines) {
            resultIndex = line.checkConnectionAndFindNextIndex(resultIndex);
        }

        return resultIndex;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
