package domain;

import java.util.List;
public class Line {
    private final List<Boolean> lines;

    public Line(List<Boolean> lines) {
        this.lines = lines;
    }

    //TODO : 네이밍
    public void method() {
        boolean state = false;
        for (boolean line : lines) {
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
}
