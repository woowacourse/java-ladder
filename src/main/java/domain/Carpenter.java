package domain;

import java.util.ArrayList;
import java.util.List;

public class Carpenter {
    private final Height height;
    private final WoodWorkMachine woodWorkMachine;

    private Carpenter(final Height height, final WoodWorkMachine woodWorkMachine) {
        this.height = height;
        this.woodWorkMachine = woodWorkMachine;
    }

    public static Carpenter of(Height height, PlayerCount playerCount) {
        return new Carpenter(height, new WoodWorkMachine(playerCount, new RandomBooleanGenerator()));
    }

    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();
        while (height.isBiggerThan(lines.size())) {
            lines.add(woodWorkMachine.makeLine());
        }
        return new Ladder(lines);
    }
}
