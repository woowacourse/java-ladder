package domain;

import java.util.ArrayList;
import java.util.List;

class Line {

    private final List<Stick> sticks;

    public Line(StickGenerator stickGenerator, int playerSize) {
        List<Stick> sticks = new ArrayList<>();

        for (int i = 0; i < playerSize; i++) {
            Stick stick = stickGenerator.generateOne();

            if (i != 0 && sticks.get(i - 1) == stick) {
                stick = Stick.getOpposite(stick);
            }

            sticks.add(stick);
        }

        this.sticks = sticks;
    }

    public List<Stick> getSticks() {
        return sticks;
    }
}
