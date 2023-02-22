package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int numberOfLine;
    private final List<LineStatus> line;

    public Line(int numberOfLineStatus, BooleanGenerator booleanGenerator) {
        this.numberOfLine = numberOfLineStatus;
        this.line = makeLine(booleanGenerator);
    }

    private List<LineStatus> makeLine(BooleanGenerator booleanGenerator) {
        List<LineStatus> line = new ArrayList<>();
        makeFirstLineStatus(booleanGenerator, line);
        makeElseLineStatus(booleanGenerator, line);
        return line;
    }

    private void makeFirstLineStatus(BooleanGenerator booleanGenerator, List<LineStatus> line) {
        line.add(LineStatus.findBy(booleanGenerator.generate(false)));
    }

    private void makeElseLineStatus(BooleanGenerator booleanGenerator, List<LineStatus> line) {
        for (int i = 1; i < this.numberOfLine; i++) {
            int leftIndex = i - 1;
            line.add(LineStatus.findBy(booleanGenerator.generate(line.get(leftIndex).getStatus())));
        }
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
