package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final Width width;
    private final List<Line> ladders;

    public Ladder(Height height, Width width) {
        this.height = height;
        this.width = width;
        this.ladders = new ArrayList<>();
    }

    public void make(LineGenerator lineGenerator) {
        for (int floor = 0; floor < height.getHeight(); floor++) {
            ladders.add(new Line(lineGenerator.generateLadder(width.getWidth())));
        }
    }

    public List<Line> getLadders() {
        return new ArrayList<>(ladders);
    }
}
