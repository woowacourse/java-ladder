package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;
    private final Height height;

    public Ladder(int personCount, Height height, BooleanGenerator booleanGenerator) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            this.lines.add(new Line(personCount, booleanGenerator));
        }
        this.height = height;
    }

    public List<Line> getLines() {
        return lines;
    }
}
