package domain;

import java.util.List;
import util.LineGenerator;
import util.LineMaker;

public class Line {
    private final List<LineStatus> line;

    public Line(int numberOfLine, LineGenerator lineGenerator) {
        this.line = LineMaker.makeLine(lineGenerator, numberOfLine);
    }

    public List<LineStatus> getLine() {
        return this.line;
    }
}
