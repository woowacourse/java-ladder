package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {
    private final Height height;
    private final int width;
    private final List<Ladder> ladders;

    public Ladders(Height height, int width) {
        this.height = height;
        this.width = width;
        this.ladders = new ArrayList<>();
    }

    public void make(LadderGenerator ladderGenerator) {
        for (int floor = 0; floor < height.getHeight(); floor++) {
            ladders.add(new Ladder(ladderGenerator.generateLadder(width)));
        }
    }

    public List<Ladder> getLadders() {
        return new ArrayList<>(ladders);
    }
}
