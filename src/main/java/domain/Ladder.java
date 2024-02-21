package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(Players players, Height height, BooleanGenerator booleanGenerator) {
        while (height.isRemain()) {
            lines.add(new Line(players.getSize(), booleanGenerator));
            height.decrease();
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
