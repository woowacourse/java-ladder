package model;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Path> line;

    public Line(List<Path> line) {
        this.line = line;
    }

    public List<Path> getLine() {
        return Collections.unmodifiableList(line);
    }
}
