package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Bar> line;

    public Line(List<Bar> bars) {
        line = new ArrayList<>(bars);
    }

    public List<Bar> getLine() {
        return line;
    }

}

