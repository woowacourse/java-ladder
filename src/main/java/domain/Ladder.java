package domain;

import util.LineGenerator;

public class Ladder {

    private final Lines lines;
    private final int numberOfWalls;
    private final Height height;

    public Ladder(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.numberOfWalls = numberOfWalls;
        this.height = height;
        this.lines = new Lines(numberOfWalls, height, lineGenerator);
    }

    public Lines getLines() {
        return lines;
    }
}
