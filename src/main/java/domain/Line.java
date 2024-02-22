package domain;

import util.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;
    private final int columnLength;

    public Line(int columnLength) {
        this.points = new ArrayList<>();
        this.columnLength = columnLength;
    }

    public List<Boolean> makeLine(BooleanGenerator booleanGenerator) {
        for (int position = 0; position < columnLength - 1; position++) {
            boolean isConnectable = booleanGenerator.generate();

            points.add(decideConnectable(position, isConnectable));
        }

        return points;
    }

    public boolean decideConnectable(int position, boolean isConnectable) {
        if (position == 0 || !points.get(position - 1)) {
            return isConnectable;
        }

        return false;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
