package domain;

import util.LineGenerator;

public class Ladder {

    private final Lines lines;

    public Ladder(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.lines = new Lines(numberOfWalls, height, lineGenerator);
    }

    public Lines getLines() {
        return lines;
    }
}
