package model;

import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int personCount, LadderHeight height, Generator generator) {
        for (int index = 0; index < height.getLadderHeight(); index++) {
            this.ladder.add(makeLadderLine(personCount, generator));
        }
    }

    private Line makeLadderLine(int personCount, Generator generator) {
        return new Line(personCount, generator);
    }

    public boolean existLadderLine(int column, int row) {
        return ladder.get(row).getLine(column);
    }

    public int getLadderSize() {
        return ladder.size();
    }

    public int getLadderLineSize(int row) {
        return ladder.get(row).getLineSize();
    }
}
