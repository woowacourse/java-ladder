package domain.ladder;

import domain.generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int count, int height, BooleanGenerator booleanGenerator) {
        Height linesHeight = new Height(height);
        for (int i = 0; i < linesHeight.getHeight(); i++) {
            lines.add(new Line(count, booleanGenerator));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getExitPosition(int entranceIndex) {
        int index = entranceIndex;
        for (int step = 0; step < lines.size(); step++) {
            index = lines.get(step).getNextStepIndex(index);
        }
        return index;
    }
}
