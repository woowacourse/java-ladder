package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bar> line;

    public Line(List<Bar> bars) {
        line = new ArrayList<>(bars);
    }

    public List<Bar> getLine() {
        return Collections.unmodifiableList(line);
    }

}

