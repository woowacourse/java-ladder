package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_LEFT = -1;
    private static final int DIRECTION_DOWN = 0;

    private final List<Bar> line;

    public Line(List<Bar> bars) {
        line = new ArrayList<>(bars);
    }

    public List<Bar> getLine() {
        return Collections.unmodifiableList(line);
    }

    public int decideDirection(int index) {
        if(index != line.size() && line.get(index) == Bar.MOVABLE_BAR) {
            return DIRECTION_RIGHT;
        }

        if(index != 0 && line.get(index - 1) == Bar.MOVABLE_BAR) {
            return DIRECTION_LEFT;
        }

        return DIRECTION_DOWN;
    }

}

