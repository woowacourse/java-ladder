package model;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int personCount, LadderHeight height) {
        for (int index = 0; index < height.getLadderHeight(); index++) {
            this.ladder.add(makeLadderLine(personCount));
        }
    }

    private Line makeLadderLine(int personCount) {
        return new Line(personCount, new LineGenerator());
    }

    public Line getLadder(int row) {
        return ladder.get(row);
    }
}
