package domain;

import util.BooleanGenerator;

public class Ladder {

    private final Lines lines;

    public Ladder(int numberOfWalls, Height height, BooleanGenerator booleanGenerator) {
        this.lines = new Lines(numberOfWalls, height, booleanGenerator);
    }

    public Lines getLines() {
        return lines;
    }
}
