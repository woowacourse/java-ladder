package domain.ladder;

import domain.Height;
import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    private Ladder(final BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public static Ladder of(final BooleanGenerator booleanGenerator) {
        return new Ladder(booleanGenerator);
    }

    public void build(final Height height, final int width) {
        generateLines(height, width, booleanGenerator);
    }

    private void generateLines(final Height height, final int width, BooleanGenerator booleanGenerator) {
        while(height.isNotBottom()){
            Line currentLine = Line.of(width, booleanGenerator);
            currentLine.generateSteps();
            this.lines.add(currentLine);
        }
    }

    public List<List<Boolean>> getConnectedToRightConditionsOfAll() {
        return lines.stream()
                .map(Line::getConnectedToRightConditions)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }

    public int ride(int startingPoint, int indexFromTop) {
        if (indexFromTop == lines.size()) {
            return startingPoint;
        }

        Line line = lines.get(indexFromTop);
        if (line.isConnectedToLeft(startingPoint)) {
            return ride(startingPoint - 1, indexFromTop + 1);
        }
        if (line.isConnectedToRight(startingPoint)) {
            return ride(startingPoint + 1, indexFromTop + 1);
        }
        return ride(startingPoint, indexFromTop + 1);
    }
}
