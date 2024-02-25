package domain;

import util.LineItemGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Height height, int columnLength, LineItemGenerator lineItemGenerator) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line(columnLength);
            line.makeLine(lineItemGenerator);

            ladder.add(line);
        }
        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
