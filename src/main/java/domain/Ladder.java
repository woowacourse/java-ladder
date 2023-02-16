package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int personCount) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < height.getHeight(); index++) {
            lines.add(new Line(personCount));
        }
    }

    public void generateLadder(BooleanGenerator booleanGenerator) {
        for (Line line : lines) {
            line.generate(booleanGenerator);
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }
    public List<List<Boolean>> getStatus() {
        return lines.stream()
                .map(Line::getBridges)
                .collect(Collectors.toList());
    }
}
