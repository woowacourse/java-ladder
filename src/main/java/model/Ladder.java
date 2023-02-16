package model;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladderLine = new ArrayList<>();

    public Ladder(Names names, LadderHeight height) {
        for (int index = 0; index < height.getLadderHeight(); index++) {
            this.ladderLine.add(new Line(names.getNames().size(), new LineGenerator()));
        }
    }

    public Line getLadder(int row) {
        return ladderLine.get(row);
    }
}
