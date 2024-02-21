package domain;

import java.util.ArrayList;
import java.util.List;

class Line {

    private final List<Stick> sticks;

    public Line(StickGenerator stickGenerator, int playerSize) {
        List<Stick> sticks = new ArrayList<>();

        for (int i = 0; i < playerSize; i++) {
            sticks.add(stickGenerator.generateOne());
        }

        this.sticks = sticks;
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
