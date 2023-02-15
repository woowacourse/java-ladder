package laddergame.domain;

import laddergame.util.PointGenerator;
import laddergame.util.RandomPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final PointGenerator pointGenerator;
    private final List<Line> lines;

    // todo: refactoring...
    public Ladder(int playerCount, LadderHeight ladderHeight) {
        pointGenerator = new RandomPointGenerator();
        List<Line> tempLines = new ArrayList<>();
        while (!ladderHeight.isMaxHeight(tempLines.size())) {
            tempLines.add(new Line(playerCount, pointGenerator));
        }
        this.lines = List.copyOf(tempLines);
    }

    public List<Line> getLadder() {
        return lines;
    }
}
