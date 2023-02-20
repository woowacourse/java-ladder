package domain;

import util.LineGenerator;

public class Ladder {

    private Lines lines;
    private final int numberOfWalls;
    private final Height height;

    public Ladder(int numberOfWalls, Height height, LineGenerator lineGenerator) {
        this.numberOfWalls = numberOfWalls;
        this.height = height;
        this.lines = new Lines(numberOfWalls, height, lineGenerator);
        //makeLines(lineGenerator);
    }

//    public void makeLines(LineGenerator lineGenerator) {
//        //this.lines = new ArrayList<>();
//
//        for (int i = 0; i < height.getHeight(); i++) {
//            lines.add(new Line(this.numberOfWalls - 1, lineGenerator));
//        }
//
//    }

    public Lines getLines() {
        return this.lines;
    }
}
