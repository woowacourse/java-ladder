package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final Height height;
    private final Width width;
    private final List<Line> ladders;

    public Ladders(Height height, Width width) {
        this.height = height;
        this.width = width;
        this.ladders = new ArrayList<>();
    }

    public void make(LadderGenerator ladderGenerator) {
        for (int floor = 0; floor < height.getHeight(); floor++) {
            ladders.add(new Line(ladderGenerator.generateLadder(width.getWidth())));
        }
    }

    public List<Line> getLadders() {
        return new ArrayList<>(ladders);
    }
}
