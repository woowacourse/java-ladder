package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line(int personCount) {
        line = new ArrayList<>(personCount - 1);

        for (int idx = 0; idx < personCount - 1; idx++) {
            line.add(false);
        }
    }

    public List<Boolean> getLine() {
        return line;
    }
}

