package model;

import model.type.Status;
import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LINE_SIZE = 1;
    private final List<Status> points = new ArrayList<>();

    public Line(int personCount, Generator generator) {
        for (int column = 0; column < personCount - 1; column++) {
            makeLine(column, generator);
        }
    }

    private void makeLine(int column, Generator generator) {
        if (points.size() >= MINIMUM_LINE_SIZE && validateContinuousLine(column)) {
            points.add(Status.BRIDGE_DOES_NOT_EXIST);
            return;
        }
        points.add(Status.findStatus(generator.generate()));
    }

    private boolean validateContinuousLine(int index) {
        return points.get(index - 1).getStatus();
    }

    public boolean getLine(int column) {
        return points.get(column).getStatus();
    }

    public int getLineSize() {
        return points.size();
    }
}
