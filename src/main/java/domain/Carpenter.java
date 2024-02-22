package domain;

import java.util.ArrayList;
import java.util.List;

public class Carpenter {
    private final Height height;
    private final WoodWorkMachine woodWorkMachine;

    public Carpenter(final Height height, final PlayerCount playerCount) {
        this.height = height;
        this.woodWorkMachine = new WoodWorkMachine(playerCount, new RandomBooleanGenerator());
    }

    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();
        while (height.isBiggerThan(lines.size())) {
            lines.add(woodWorkMachine.makeLine());
        }
        return new Ladder(lines);
    }
}
