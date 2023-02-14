package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    //TODO : 네이밍
    public void method() {
        boolean state = false;
        for (boolean line : points) {
            state = updateState(state, line);
        }
    }

    //TODO : 네이밍
    private boolean updateState(boolean state, boolean line) {
        if (line && state) {
            throw new IllegalArgumentException();
        }
        state = line;
        return state;
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
