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
            Boolean isConnectable = booleanGenerator.generate();

            if (checkIsPossibleAddBridge(position)) {
                points.add(isConnectable);
            }

            if (!checkIsPossibleAddBridge(position)) {
                points.add(false);
            }
        }

        return points;
    }

    public boolean checkIsPossibleAddBridge(int position) {
        if (position == 0) return true;
        return !points.get(position - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
