package domain;

import java.util.ArrayList;
import java.util.List;

public class Carpenter {
    private final Height height;
    private final WoodWorkMachine woodWorkMachine;

    public Carpenter(final Height height, final PlayerCount playerCount, final NumberGenerator randomNumberGenerator) {
        this.height = height;
        this.woodWorkMachine = new WoodWorkMachine(randomNumberGenerator, playerCount);
    }

    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();
        int buildHeight = 0;
        while (height.isBiggerThan(buildHeight)) {
            lines.add(woodWorkMachine.makeLine());
            buildHeight++;
        }
        return new Ladder(lines);
    }
}
