package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    private final Height height;
    private final LineMaker lineMaker;

    private LadderMaker(final Height height, final LineMaker lineMaker) {
        this.height = height;
        this.lineMaker = lineMaker;
    }

    public static LadderMaker of(Height height, PlayerCount playerCount) {
        return new LadderMaker(height, new LineMaker(playerCount, new RandomBooleanGenerator()));
    }

    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();
        while (height.isBiggerThan(lines.size())) {
            lines.add(lineMaker.makeLine());
        }
        return new Ladder(lines);
    }
}
