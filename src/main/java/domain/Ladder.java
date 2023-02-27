package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.BooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, int personCount) {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < height.getHeight(); index++) {
            lines.add(Line.from(personCount));
        }
        return new Ladder(lines);
    }

    public void generate(BooleanGenerator booleanGenerator) {
        for (Line line : lines) {
            line.generate(booleanGenerator);
        }
    }

    public int findFinalPosition(int position) {
        for (Line line : lines) {
            position = finalPosition(position, line);
        }
        return position;
    }

    private int finalPosition(int position, Line line) {
        if (line.hasBridgeInRight(position)) {
            return position + 1;
        }
        if (line.hasBridgeInLeft(position)) {
            return position - 1;
        }
        return position;
    }

    public int calculateTotalHeight() {
        return lines.size();
    }

    public List<List<Bridge>> getStatus() {
        return lines.stream()
                .map(Line::getBridges)
                .collect(Collectors.toUnmodifiableList());
    }
}
