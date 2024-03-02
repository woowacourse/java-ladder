package domain;

import java.util.Collections;
import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Ladder{

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
