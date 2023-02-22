package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Height height;
    private final Width width;
    private final List<Line> ladder;

    public Ladder(Height height, Width width, LineGenerator randomLineGenerator) {
        this.height = height;
        this.width = width;
        this.ladder = new ArrayList<>();
        generate(randomLineGenerator);
    }

    private void generate(LineGenerator randomLineGenerator) {
        for (int floor = 0; floor < height.getHeight(); floor++) {
            ladder.add(new Line(randomLineGenerator.generateLine(width)));
        }
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
