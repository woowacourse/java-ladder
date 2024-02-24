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
        return new LadderMaker(height, new LineMaker(playerCount, new RandomStepGenerator()));
    }

    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();
        int count = height.getHeight();
        for (int index = 0; index < count; index++){
            lines.add(lineMaker.makeLine());
        }
        return new Ladder(lines);
    }
}
