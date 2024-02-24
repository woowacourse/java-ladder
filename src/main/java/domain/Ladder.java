package domain;

import util.LineItemGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder() {
        this.ladder = new ArrayList<>();
    }

    public List<Line> makeLadder(Height height, int columnLength, LineItemGenerator lineItemGenerator) {
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(columnLength);
            line.makeLine(lineItemGenerator);

            ladder.add(line);
        }

        return ladder;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
