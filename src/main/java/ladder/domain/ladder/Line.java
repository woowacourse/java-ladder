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

    public int nextPosition(int currentPosition) {
        Bar leftBar = null;
        if (currentPosition != 0) {
            leftBar = line.get(currentPosition - 1);
        }
        Bar rightBar = null;
        if (currentPosition != line.size()) {
            rightBar = line.get(currentPosition);
        }
        Direction direction = Direction.getDirection(leftBar, rightBar);
        return direction.move(currentPosition);
    }

}

