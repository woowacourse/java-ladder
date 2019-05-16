package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(Floor floor, int tagsNumber) {
        lines = new ArrayList<>();
        for (int i = 0; i < floor.getNumber(); i++) {
            lines.add(new Line(tagsNumber));
        }
    }

    public int findResultTagIndexByIndex(int index) {
        for (Line line : lines) {
            index = getIndexAfterMovingDown(line, index);
        }
        return index;
    }

    private int getIndexAfterMovingDown(Line line, int index) {
        return line.getIndexAfterMovingHorizon(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.toString());
        }
        return sb.toString();
    }
}
