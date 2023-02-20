package domain;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final int numberOfLine;
    private final List<LineStatus> line;

    public Line(int numberOfLineStatus, LineGenerator lineGenerator) {
        this.numberOfLine = numberOfLineStatus;
        this.line = makeLine(lineGenerator);
    }

    private List<LineStatus> makeLine(LineGenerator lineGenerator) {
        List<LineStatus> line = new ArrayList<>();
        makeFirstLineStatus(lineGenerator, line);
        makeElseLineStatus(lineGenerator, line);
        return line;
    }

    private void makeFirstLineStatus(LineGenerator lineGenerator, List<LineStatus> line) {
        line.add(LineStatus.findBy(lineGenerator.generate(false)));
    }

    private void makeElseLineStatus(LineGenerator lineGenerator, List<LineStatus> line) {
        for (int i = 1; i < this.numberOfLine; i++) {
            int leftIndex = i - 1;
            line.add(LineStatus.findBy(lineGenerator.generate(line.get(leftIndex).getStatus())));
        }
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
