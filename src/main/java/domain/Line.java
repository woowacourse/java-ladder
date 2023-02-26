package domain;

import java.util.List;
import generator.LineGenerator;

public class Line {

    private final List<LineStatus> line;
    private final LineGenerator lineGenerator;

    public Line(List<LineStatus> line, LineGenerator lineGenerator) {
        this.line = line;
        this.lineGenerator = lineGenerator;
    }

    public void addStatus(int numberOfLine) {
        LineMaker.makeFirstLineStatus(lineGenerator, line);
        LineMaker.makeElseLineStatus(lineGenerator, line, numberOfLine);
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
