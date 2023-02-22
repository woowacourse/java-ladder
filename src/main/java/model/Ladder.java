package model;

import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int personCount, LadderHeight height, Generator generator) {
        for (int index = 0; index < height.getLadderHeight(); index++) {
            this.ladder.add(makeLadderLine(personCount,generator));
        }
    }

    private Line makeLadderLine(int personCount,Generator generator) {
        return new Line(personCount, generator);
    }

    public boolean getLadderLine(int column, int row) {
        return ladder.get(row).getLine(column);
    }
}
